package com.ruoyi.project.system.post.domain;

import com.ruoyi.project.common.entity.BaseEntity;
import com.ruoyi.project.common.utils.ColumnUtils;
import lombok.Data;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * 岗位表 sys_post
 *
 * @author ruoyi
 */
@Entity
@Data
@Table(name = "sys_post",indexes =  { @Index(columnList = "id")})
public class Post extends BaseEntity {

    @Excel(name = "岗位编码")
    @Column(name = "post_code", columnDefinition = ColumnUtils.STRING30 + "'岗位编码'",nullable = false)
    private String postCode;

    @Excel(name = "岗位名称")
    @Column(name = "post_name", columnDefinition = ColumnUtils.STRING30 + "'岗位名称'",nullable = false)
    private String postName;


    @Excel(name = "岗位排序")
    @Column(name = "post_sort", columnDefinition = ColumnUtils.INTEGER3 + "'岗位排序'")
    private Integer postSort;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    @Column(name = "status", columnDefinition = ColumnUtils.BOOLEAN + "'状态 0=正常,1=停用'")
    private Boolean status;


}
