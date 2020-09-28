package org.st.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.st.community.model.User;

/**
 * Created with IntelliJ IDEA.
 * Description: 用户类操作mapper接口
 * User: ST
 * Date: 2020-09-25
 * Time: 14:08
 */
@Mapper
@Component
public interface UserMapper {

    @Insert("INSERT INTO USER(name, account_id, bio, token, gmt_create, gmt_modified) " +
            "VALUES (#{name}, #{accountId}, #{bio}, #{token}, #{gmtCreate}, #{gmtModified})")
    void insertUser(User user);
}
