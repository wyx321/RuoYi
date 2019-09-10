package com.ruoyi.project.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.framework.web.controller.WebController;
import com.ruoyi.project.common.entity.BaseEntity;
import com.ruoyi.project.common.service.IBaseService;
import com.ruoyi.project.common.vo.ReturnVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: demo
 * @author: wyx
 * @create: 2019-05-01 17:36
 * @description:
 **/
public abstract class BaseController<T extends BaseEntity> extends WebController {

    protected abstract IBaseService getBasicService();




    /**
     * 分页
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("page")
    @ResponseBody
    public String page(
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value ="pageSize", defaultValue = "5")Integer pageSize,
            @RequestParam HashMap<String, String> param

    ){
        PageHelper.startPage(page,pageSize);

        List list = getBasicService().pageList(param);
        PageInfo pageInfo = new PageInfo(list,pageSize);

        return ReturnVO.success(pageInfo);
    }



    /**
     * 获取所有没有标记为删除状态的数据
     * @return
     */

    @GetMapping("query")
    @ResponseBody
    public String query(){
        List<T> list = getBasicService().getAllNoCancel();
        return ReturnVO.success(list);
    }

    /**
     * 单表表通用详情查询
     */
    @GetMapping("get")
    @ResponseBody
    public String get(T t){
        T entity = (T)getBasicService().get(t);
        return ReturnVO.success(entity);
    }

    /**
     * 多表通用详情查询
     * @param id
     * @return
     */
    @GetMapping("getById/{id}")
    @ResponseBody
    public String getById(@PathVariable(name = "id")Long id){
        Map map = getBasicService().getById(id);
        return ReturnVO.success(map);
    }

    /**
     * 保存/编辑 数据
     *
     * @param t
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public String save(@RequestParam Map<String, String> params, T t){

            List list = null;
            // 本次保存到数据库中的数据
            T saveData;
            StringBuilder error = new StringBuilder();
            // 设置其他值到本次保存数据中
            saveData = setSubmitData( params, t,error);
            if (StringUtils.isNotEmpty(error)) {
                return ReturnVO.error(error.toString());
            }
            Long entityId = getBasicService().save(saveData);
            return ReturnVO.success(entityId);
    }


    /**
     * 保存业务实体类（可由实现类重写）
     * 业务数据检测自定义异常
     * @param
     * @param params
     * @param t
     * @param
     * @param
     * @return
     * @throws
     */
    protected T setSubmitData(
            Map<String, String> params, T t,StringBuilder error
            )
             {
        return t;
    }

    /**
     * 删除，删除即为更新数据为删除状态
     * @param t
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public String delete(T t) {
        getBasicService().remove(t);
        return ReturnVO.success();
    }

    /**
     * 批量删除
     * @param ids
     */
    @RequestMapping(value = "deleteByIds")
    @ResponseBody
    public String deleteByIds(@RequestBody String ids){

        JSONArray array = JSON.parseObject(ids).getJSONArray("ids");
        List<Long> list = array.toJavaList(Long.class);
        getBasicService().deleteById(list);
        return ReturnVO.success();

    }
}
