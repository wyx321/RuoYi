package com.ruoyi.project.system.post.mapper;

import java.util.List;

import com.ruoyi.project.common.mapper.BaseMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 岗位信息 数据层
 * 
 * @author ruoyi
 */
@Repository
@Mapper
public interface PostMapper extends BaseMapper<Post>
{
    /**
     * 查询岗位数据集合
     * 
     * @param post 岗位信息
     * @return 岗位数据集合
     */
    @Override
    List<Post> select(Post post);

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
     */
    public int deletePostByIds(Long[] ids);


}
