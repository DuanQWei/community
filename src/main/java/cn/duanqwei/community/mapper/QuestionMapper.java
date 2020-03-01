package cn.duanqwei.community.mapper;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.dto.QuestionDto;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface QuestionMapper extends Mapper<Question> {
    //查询出所有的问题
    List<QuestionDto> getQuestionList();


}
