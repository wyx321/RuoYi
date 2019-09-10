package com.ruoyi.project.common.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


/**
 * @project: crm-springboot
 * @author: TYX
 * @create: 2019-01-21 16:45
 * @description: 接口返回统一VO
 **/
public class ReturnVO {

    /**
     * Fastjson 实体类JSON化过滤字段操作-PropertyFilter
     */
    private static PropertyFilter filter;

    private static SerializeConfig serializeConfig;

    /**
     * 返回统一状态码
     * 0：成功 -1：失败
     */
    static final int SUCCESS = 0;
    static final int ERROR = -1;
    static final String successMsg = "请求成功";
    static final String errorMsg = "请求失败";


    /**
     * 返回 成功数据
     * @param
     * @return
     */

    public static String success() {
        return toJSON(SUCCESS, successMsg,null);
    }


    public static String success(Object data) {
        return toJSON(SUCCESS, successMsg, data);
    }



    /**
     * 返回成功 分页数据结构
     * @param count
     * @param data
     * @return
     */
    public static String success(Integer count,Object data) {
        return toJSON(SUCCESS, successMsg,count, data);
    }

    /**
     * 返回失败数据
     * @return
     */
    public static String error() {
        return toJSON(ERROR, errorMsg, null);
    }

    public static String error(String message) {
        return toJSON(ERROR, message, null);
    }

    public static String error(Object data) {
        return toJSON(ERROR, null, data);
    }


    /**
     *
     * @param code
     * @param message
     * @param
     * @return
     */
    public static String toJSON(int code, String message, Object data) {

        StringBuilder json = new StringBuilder("{\"code\":" + code);
        if (StringUtils.isNoneEmpty(message)) {
            json.append(",\"msg\":\"" + message + "\"");
        }
        if (data != null) {
            json.append(",\"data\":"
                    + JSON.toJSONString(data, getSerializeConfig(), getPropertyFilter()
                    , SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullStringAsEmpty));
        }
        return json.toString() + "}";
    }

    /**
     * 返回分页数据结构
     * @param code
     * @param message
     * @param count 总记录数
     * @param data
     * @return
     */
    public static String toJSON(int code, String message,Integer count, Object data) {

        StringBuilder json = new StringBuilder("{\"code\":" + code);
        if (StringUtils.isNoneEmpty(message)) {
            json.append(",\"msg\":\"" + message + "\"");
        }
        if (count != null){
            json.append(",\"count\":\"" + count + "\"");
        }
        if (data != null) {
            json.append(",\"data\":"
                    + JSON.toJSONString(data, getSerializeConfig()
                    , SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullStringAsEmpty));
        }
        return json.toString() + "}";
    }


    /**
     * 过滤掉 数据创建时间 和 是否被删除状态 属性值
     * @return
     */
    public static PropertyFilter getPropertyFilter() {
        if (Objects.isNull(filter)) {
            filter = (source, name, value) ->
                    !StringUtils.equals(name, "cancel");
        }
        return filter;
    }

    /**
     * 返回统一时间格式
     * @return
     */
    public static SerializeConfig getSerializeConfig() {
        if (Objects.isNull(serializeConfig)) {
            serializeConfig = new SerializeConfig();
            serializeConfig.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd"));
            serializeConfig.put(Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd"));
        }
        return serializeConfig;
    }
}
