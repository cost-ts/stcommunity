package org.st.community.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * @Description: 用户实体类
 * @author: ST
 * @Date: 2020-09-25
 * @Time: 14:12
 */
@Data
public class User {
    /**
     * ID标识
     */
    private Integer id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 账户ID
     */
    private String accountId;
    /**
     * 令牌
     */
    private String token;
    /**
     * url
     */
    private String avatarUrl;
    /**
     * 个人说明
     */
    private String bio;
    /**
     * 创建时间
     */
    private Long gmtCreate;
    /**
     * 修改时间
     */
    private Long gmtModified;
}
