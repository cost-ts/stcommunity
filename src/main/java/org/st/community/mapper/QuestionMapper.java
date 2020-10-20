package org.st.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.st.community.model.Question;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 用户提问类Mapper接口
 * @author: ST
 * @Date: 2020-10-10
 * @Time: 16:48
 */
@Mapper
@Component
public interface QuestionMapper {

    /**
     * 保存用户提问信息
     *
     * @param question 问题
     */
    @Insert("INSERT INTO question(title, description, gmt_create, gmt_modified, creator, tag)" +
            "VALUES(#{title}, #{description}, #{gmtCreate}, #{gmtModified}, #{creator}, #{tag})")
    void create(Question question);
}
