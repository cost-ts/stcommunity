package org.st.community.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 问题实体类
 * @author: ST
 * @Date: 2020-10-10
 * @Time: 16:53
 */
@Data
public class Question {
    /**
     * ID标识
     */
    private Integer id;
    /**
     * 问题标题
     */
    private String title;
    /**
     * 问题描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Long gmtCreate;
    /**
     * 修改时间
     */
    private Long gmtModified;
    /**
     * 创建人(ID)
     */
    private Integer creator;
    /**
     * 标签
     */
    private String tag;
    /**
     * 评论数
     */
    private Integer commentCount;
    /**
     * 浏览数
     */
    private Integer viewCount;
    /**
     * 点赞数
     */
    private Integer likeCount;
}
