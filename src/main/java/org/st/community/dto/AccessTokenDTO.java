package org.st.community.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 获取Github token所需要的参数
 * User: ST
 * Date: 2020-09-04
 * Time: 0:39
 */
@Data
public class AccessTokenDTO {
    /**
     * 账户ID
     */
    private String client_id;
    /**
     * 账户密匙
     */
    private String client_secret;
    /**
     * 接受码
     */
    private String code;
    /**
     * 回调url
     */
    private String redirect_uri;
    /**
     * 状态码
     */
    private String state;
}
