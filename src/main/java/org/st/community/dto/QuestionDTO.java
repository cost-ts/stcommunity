package org.st.community.dto;

import lombok.Data;
import org.st.community.model.Question;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 问题列表封装类
 * @author: ST
 * @Date: 2020-10-26
 * @Time: 17:59
 */
@Data
public class QuestionDTO extends Question {
    /**
     * 用户头像
     */
    private String avatarUrl;
}
