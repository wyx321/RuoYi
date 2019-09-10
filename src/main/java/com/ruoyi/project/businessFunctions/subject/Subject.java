package com.ruoyi.project.businessFunctions.subject;

import com.ruoyi.project.common.entity.BaseEntity;
import com.ruoyi.project.common.utils.ColumnUtils;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * @project: crm
 * @author: WYX
 * @create: 2019-08-08 16:43
 * @description: 学科
 **/
@Entity
@Data
@Table(name = "b_subject",indexes =  { @Index(columnList = "id")})
public class Subject extends BaseEntity {

    @Column(name = "name", columnDefinition = ColumnUtils.STRING30 + "'课程名称'",nullable = false)
    private String name;

    @Column(name = "code", columnDefinition = ColumnUtils.STRING30 + "'课程编号'",nullable = false)
    private String code;
}
