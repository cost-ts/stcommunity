package org.st.community.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.st.community.dto.QuestionDTO;
import org.st.community.mapper.QuestionMapper;
import org.st.community.service.QuestionService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 问题服务实现类
 * @author: ST
 * @Date: 2020-10-27
 * @Time: 11:04
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询问题列表及相关用户信息
     *
     * @return 查询结果
     */
    @Override
    public List<QuestionDTO> selectList() {
        // 查询问题列表
        List<QuestionDTO> questions = questionMapper.selectList();
        return questions;
    }
}
