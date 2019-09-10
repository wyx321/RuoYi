package com.ruoyi.project.businessFunctions.UserTest.entity;

import com.ruoyi.project.common.entity.BaseEntity;
import com.ruoyi.project.common.utils.ColumnUtils;
import lombok.Data;

import javax.persistence.*;

/**
 * @project: crm
 * @author: WYX
 * @create: 2019-08-07 14:06
 * @description: 城市
 **/
@Entity
@Data
@Table(name = "b_user",indexes =  { @Index(columnList = "id")})
public class userTest extends BaseEntity {

    @Column(name = "login_name", columnDefinition = ColumnUtils.STRING30 + "'登录名称'",nullable = false)
    private String loginName;

    @Column(name = "password", columnDefinition = ColumnUtils.STRING30 + "'登录密码'",nullable = false)
    private String password;

    @Column(name = "user_name", columnDefinition = ColumnUtils.STRING30 + "'用户名称'",nullable = false)
    private String userName;

    @Column(name = "sex",columnDefinition = ColumnUtils.INTEGER1 + "'性别 0=男,1=女,2=未知'",nullable = false)
    private Integer sex;

    @Column(name = "email", columnDefinition = ColumnUtils.STRING30 + "'邮箱'")
    private String email;

    @Column(name = "phone_number", columnDefinition = ColumnUtils.STRING30 + "'手机号'")
    private String phoneNumber;

    @Column(name = "status", columnDefinition = ColumnUtils.INTEGER1 + "'帐号状态 0=正常,1=停用'")
    private Integer status;


    /**
     * 中间表
     */
    //@ManyToMany
    //@JoinTable(name = "b_student_subject",
    //joinColumns = {@JoinColumn (name = "student_id",referencedColumnName = "id")},
    //inverseJoinColumns = {@JoinColumn(name = "subject_id",referencedColumnName = "id")})
    //private List<Subject> subjects;

}
