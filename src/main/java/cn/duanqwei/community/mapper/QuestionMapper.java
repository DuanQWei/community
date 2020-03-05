package cn.duanqwei.community.mapper;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.dto.QuestionDto;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface QuestionMapper extends Mapper<Question> {



    Integer count();


    List<QuestionDto> selectInfo();

    List<QuestionDto> selectById(@Param("id") Integer id);

    Question queryById(@Param("id")Integer id);
}
