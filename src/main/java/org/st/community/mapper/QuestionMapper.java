package org.st.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.st.community.dto.QuestionDTO;
import org.st.community.model.Question;

import java.util.List;

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

    /**
     * 查询问题列表及相关联的用户头像
     *
     * @return 查询结果
     */
    @Select("SELECT q.title, q.creator, q.comment_count, q.view_count, q.gmt_create, u.avatar_url FROM QUESTION `q`" +
            "JOIN USER `u` ON q.creator = u.id")
    List<QuestionDTO> selectList();
}
