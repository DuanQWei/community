package cn.duanqwei.community.service.impl;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.mapper.QuestionMapper;
import cn.duanqwei.community.mapper.UserMapper;
import cn.duanqwei.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer count() {
        return questionMapper.count();
    }

    /**
     * 发布
     * @param question
     */
    @Override
    public void create(Question question) {
        questionMapper.insert(question);
    }

    //根据用户Id查询出来用户发布的问题
    @Override
    public List<QuestionDto> list(Integer id) {
        List<QuestionDto> questionList = questionMapper.selectById(id);
        return questionList;
    }

    @Override
    public QuestionDto getQuestionById(Integer id) {
        Question question= questionMapper.queryById(id);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question,questionDto);
        return questionDto;
    }
}
