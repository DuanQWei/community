package cn.duanqwei.community.service;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    //查询问题的个数
    public Integer count();

    //发起一个问题
    public void create(Question question);

    List<QuestionDto> list(Integer id);

    QuestionDto getQuestionById(Integer id);
}
