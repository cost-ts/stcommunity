package org.st.community.community.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 获取到的Github信息
 * User: ST
 * Date: 2020-09-04
 * Time: 1:30
 */
@Data
public class GithubUser {
    /**
     * Github用户ID
     */
    private long id;
    /**
     * Github用户名
     */
    private String name;
    /**
     * Github用户描述
     */
    private String bio;
}
