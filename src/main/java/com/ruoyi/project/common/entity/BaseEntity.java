package com.ruoyi.project.common.entity;

import com.ruoyi.project.common.utils.ColumnUtils;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @project: crm-springboot
 * @author: TYX
 * @create: 2019-01-21 15:47
 * @description: 基础实体类
 */
@MappedSuperclass
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseEntity implements Serializable {

  @Column(
      name = "is_cancel",
      nullable = false,
      columnDefinition = ColumnUtils.BOOLEAN + "'删除状态(0、未删除，1、删除)'")
  private Boolean cancel = false;
  @Column(
      name = "create_time",
      nullable = false,
      insertable = false,
      columnDefinition = ColumnUtils.TIME_NOW + "'数据新建时间'")
  private Date createTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = ColumnUtils.LONG + "'主键'")
    private Long id;
}
