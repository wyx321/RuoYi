package com.ruoyi.project.system.post.service;

import java.util.List;

import com.ruoyi.project.common.service.IBaseService;
import com.ruoyi.project.system.post.domain.Post;

/**
 * 岗位信息 服务层
 * 
 * @author ruoyi
 */
public interface IPostService extends IBaseService<Post>
{

    /**
     * 根据用户ID查询岗位
     * 
     * @param userId 用户ID
     * @return 岗位列表
     */
    public List<Post> selectPostsByUserId(Long userId);


    /**
     * 批量删除岗位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deletePostByIds(String ids) throws Exception;




    /**
     * 通过岗位ID查询岗位使用数量
     * 
     * @param postId 岗位ID
     * @return 结果
     */
    public int countUserPostById(Long postId);


}
