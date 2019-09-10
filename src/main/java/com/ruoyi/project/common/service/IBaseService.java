package com.ruoyi.project.common.service;

import com.ruoyi.project.common.entity.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @author: wyx
 * @create: 2019-04-27 20:35
 * @description:
 **/
public  interface IBaseService<T extends BaseEntity> {



    /**
     * 计算没有标记被删除的总记录数
     * @return
     */
    int count();


    /**
     * 获取所有没有标记为删除状态的数据
     *
     * @return
     */
    List<T> getAllNoCancel();


    /**
     * 查询所有数据
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 通过ID查询对象
     * @param o
     * @return
     */
    T selectById(Object o);

    T selectOne(T t);

    /**
     * 分页带查询
     * @param param
     * @return
     */
    List<Map<String,Object>> pageList(Map<String, String> param);

    /**
     * 单表通用详情查询
     *
     * @param
     * @return
     */
    T get(T t);

    /**
     * 多表通用详情查询
     * @param id
     * @return
     */
    Map<String,Object> getById(Long id);


    /**
     * 保存
     * @param t
     * @return
     */
    Long save(T t);


    /**
     * 删除，删除即为更新数据为删除状态
     * @param t
     * @return
     */
    void remove(T t);


    /**
     * 获取插入的ID
     * @return
     */
    List<Long> getInsertId();

    /**
     * 检测ID在不在数据库中
     *
     * @param clazz 类名称
     * @return id
     */
    T  checkIdInDatabase(Class<?> clazz, Long id);


    /**
     * 验证数据唯一
     * @param param
     * @return
     */
    int selCount(Map<String, String> param);

    /**
     * 批量删除
     * @param ids
     */
    int deleteById(List<Long> ids);
}
