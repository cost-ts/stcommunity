package org.st.community.service;

import org.st.community.dto.QuestionDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 问题服务类
 * @author: ST
 * @Date: 2020-10-27
 * @Time: 11:04
 */
public interface QuestionService {

    List<QuestionDTO> selectList();
}
