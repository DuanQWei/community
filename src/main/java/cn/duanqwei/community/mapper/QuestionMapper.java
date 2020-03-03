package cn.duanqwei.community.mapper;

import cn.duanqwei.community.bean.Question;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface QuestionMapper extends Mapper<Question> {


    List<Question> list(@Param(value = "offset") Integer offset,@Param(value = "size") Integer size);


    Integer count();



}
