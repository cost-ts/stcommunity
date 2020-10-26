package org.st.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.st.community.model.User;

/**
 * Created with IntelliJ IDEA.
 * @Description: 用户类操作mapper接口
 * @author: ST
 * @Date: 2020-09-25
 * @Time: 14:08
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 保存用户信息
     * @param user 用户
     */
    @Insert("INSERT INTO USER(name, account_id, bio, token, gmt_create, gmt_modified, avatar_url) " +
            "VALUES (#{name}, #{accountId}, #{bio}, #{token}, #{gmtCreate}, #{gmtModified}, #{avatarUrl})")
    void insertUser(User user);

    /**
     * 通过token查询用户信息
     * @param token 令牌
     * @return User对象
     */
    @Select("SELECT * FROM USER WHERE token = #{token}")
    User findByToken(@Param("token") String token);
}
