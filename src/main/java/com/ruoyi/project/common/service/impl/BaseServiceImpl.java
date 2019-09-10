package com.ruoyi.project.common.service.impl;

import com.ruoyi.project.common.entity.BaseEntity;
import com.ruoyi.project.common.mapper.BaseMapper;
import com.ruoyi.project.common.service.IBaseService;
import javax.persistence.Table;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @program: demo
 * @author: wyx
 * @create: 2019-04-27 20:39
 * @description:
 **/
public abstract class BaseServiceImpl<T extends BaseEntity> implements IBaseService<T> {



    /**
     * 子类实现各自的mapper
     *
     * @return
     */
    public abstract BaseMapper getMapper();

    private Class<T> tClass;
    /** 用于查询没有删除的状态过滤条件 */
    private BaseEntity noCancel;

    /** 获得超类的泛型参数的实际类型 */
    public BaseServiceImpl() {
        tClass =
                (Class<T>)
                        ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    /**
     * 验证数据唯一
     * @param param
     * @return
     */
    @Override
    public int selCount(Map<String, String> param) {
        return getMapper().selCount(param);
    }

    /**
     * 获取插入的ID
     *
     * @return
     */
    public List<Long> getInsertId() {
        return getMapper().getInsertId();
    }

    /**
     * 计算没有标记被删除的总记录数
     * @return
     */
    @Override
    public int count() {
        return getMapper().selectCount(getNoCancel());
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public int deleteById(List<Long> ids) {
        return getMapper().deleteById(ids);
    }

    /**
     * 通用详情查询
     *
     * @param
     * @return
     */
    @Override
    public T get(T t) {
        try {
//            T query = tClass.newInstance();
            return (T)getMapper().selectOne(t);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 分页带查询
     * @param param
     * @return
     */
    @Override
    public List<Map<String, Object>> pageList(Map<String, String> param) {
        return getMapper().pageList(param);
    }

    /**
     * 获取所有没有标记为删除状态的数据
     * @return
     */
    @Override
    public List<T> getAllNoCancel() {
        return getMapper().select(getNoCancel());
    }

    @Override
    public T selectById(Object o) {
        return (T)getMapper().selectByPrimaryKey(o);
    }

    @Override
    public T selectOne(T t) {
        return (T)getMapper().selectOne(t);
    }

    /**
     * 保存数据
     *
     * @param t
     * @return
     */
    @Override
    public Long save(T t) {
        t = saveBeforeData(t);
        if (Objects.isNull(t.getId())) {
            insertData(t);
        } else {
            updateData(t);
        }
        saveAfterDate(t);
        return t.getId();
    }

    /**
     * 保存之前的业务方法，可以重写
     *
     * @param t
     * @return
     */
    protected T saveBeforeData(T t) {
        return t;
    }

    /**
     * 保存之后
     *
     * @param t
     */
    protected void saveAfterDate(T t) {}

    /**
     * 新增的业务方法，可以重写
     *
     * @param t
     */
    protected void insertData(T t) {
        if (getMapper().insert(t) > 0){
            setId(t);
        }
    }

    /**
     * 将insert的ID保存到对象中
     *
     * @param o
     * @param <V>
     */
    public <V extends BaseEntity> void setId(V o) {
        if (Objects.isNull(o.getId())) {
            o.setId(insertId());
        }
    }

    /**
     * 获取插入的ID
     *
     * @return
     */
    private Long insertId() {
        return (Long) getMapper().getInsertId().get(0);
    }





    /**
     * 更新数据的业务方法，可以重写
     *
     * @param t
     */
    protected void updateData(T t) {
        //更新对象不为空的数据
        getMapper().updateByPrimaryKeySelective(t);
    }

    /**
     * 多表通用详情查询
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> getById(Long id) {
        return getMapper().getById(id);
    }

    @Override
    public List<T> select(T t) {
        return getMapper().select(t);
    }

    /**
     * 删除，删除即为更新数据为删除状态
     * @param t
     * @return
     */
    @Override
    public void remove(T t) {
        t.setCancel(true);
        t.setCreateTime(new Date());
        getMapper().updateByPrimaryKey(t);
    }


    public BaseEntity getNoCancel() {
        if (Objects.isNull(noCancel)) {
            try {
                noCancel = tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return noCancel;
    }


    /**
     * 检测ID在不在数据库中
     *
     * @param clazz 类名称
     * @return id
     */
    @Override
    public  T checkIdInDatabase(Class<?> clazz, Long id) {
        if (Objects.nonNull(clazz) && Objects.nonNull(id)){
            /** 通过获取类上的@Table注解获取表名称 */
            Table annotation = clazz.getAnnotation(Table.class);
            String tableName = annotation.name();
            T t = (T) getMapper().checkIdInDatabase(tableName, id);
            if (t != null){
                return t;
            }else {
                return null;
            }
        }
        return null;
    }
}
