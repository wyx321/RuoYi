package com.ruoyi.project.common.utils;

/**
 * @project: crm
 * @author: TYX
 * @create: 2019-02-28 14:00
 * @description: 字段类型
 */
public class ColumnUtils {

    /**
     * 小数
     */
    public static final String BIG_DECIMAL = "decimal(10,4) COMMENT ";
    public static final String BIG_DECIMAL_DEFAULT0 = "decimal(10,4) DEFAULT 0 COMMENT ";
    /**
     * 判断值
     */
    public static final String BOOLEAN = "bit(1) DEFAULT 0 COMMENT ";
    public static final String BOOLEAN_NO_DEFAULT = "bit(1) COMMENT ";
    public static final String DOUBLE = "double(6, 2) COMMENT ";
    public static final String DOUBLE_DEFAULT0 = "double(6, 2) DEFAULT 0 COMMENT ";
    /**
     * 1位的integer
     */
    public static final String INTEGER1 = "INTEGER(1) COMMENT ";
    /**
     * 3位的integer
     */
    public static final String INTEGER3 = "INTEGER(3) COMMENT ";
    /**
     * Long数据类型
     */
    public static final String LONG = "bigint(20) COMMENT ";
    /**
     * 字符串长度100
     */
    public static final String STRING = "varchar(100) COMMENT ";
    /**
     * 字符串长度255
     */
    public static final String STRING255 = "varchar(255) COMMENT ";
    /**
     * 字符串长度30
     */
    public static final String STRING30 = "varchar(30) COMMENT ";

    public static final String STRING500 = "varchar(500) COMMENT ";
    /**
     * 文本
     */
    public static final String TEXT = "text COMMENT ";
    /**
     * 日期
     */
    public static final String TIME = "datetime(0) NULL COMMENT ";
    /**
     * 默认当前时间
     */
    public static final String TIME_NOW = "datetime DEFAULT CURRENT_TIMESTAMP COMMENT ";
}
