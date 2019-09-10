package com.ruoyi.project.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: demo
 * @author: wyx
 * @create: 2019-05-20 21:46
 * @description:
 **/
@Data
public class Tree {

    private String id;

    private String name;

    private String parentId;

    private List<Tree> childMenu;
}
