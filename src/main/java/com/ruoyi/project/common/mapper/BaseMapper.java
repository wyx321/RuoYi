package com.ruoyi.project.common.mapper;

import com.ruoyi.project.common.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

import java.util.List;
import java.util.Map;


/**
 * @project: crm
 * @author: WYX
 * @create: 2019-04-23 12:29
 * @description: 通用mapper父类
 **/
public  interface BaseMapper<T extends BaseEntity> extends BaseSelectMapper<T>, BaseInsertMapper<T>, BaseDeleteMapper<T>, BaseUpdateMapper<T> {

    /**
     * 获取insert ID
     * @return
     */
    @Select("SELECT LAST_INSERT_ID()")
    List<Long> getInsertId();



    /**
     * 检测ID在不在数据库中
     *
     * @param tableName
     * @param
     * @return
     */
    @Select("SELECT id  from ${tableName} where id = ${id}")
    T checkIdInDatabase(
            @Param("tableName") String tableName, @Param("id") Long id);


    /**
     * 分页带查询
     * @param param
     * @return
     */
    List<Map<String,Object>> pageList(@Param("param") Map<String, String> param);

    /**
     * 多表根据ID获取详情
     * @param id
     * @return
     */
    Map<String,Object> getById(@Param("id") Long id);

    /**
     * 验证数据唯一
     * @param param
     * @return
     */
    int selCount(@Param("param") Map<String, String> param);


    /**
     * 批量删除
     * @param ids
     */
    int deleteById(@Param("ids") List<Long> ids);
}
