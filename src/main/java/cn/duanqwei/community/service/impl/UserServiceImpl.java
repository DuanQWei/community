package cn.duanqwei.community.service.impl;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.PageDto;
import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.mapper.QuestionMapper;
import cn.duanqwei.community.mapper.UserMapper;
import cn.duanqwei.community.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 注册一个用户
     * @param user
     */
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User queryUserByname(String username) {

        return userMapper.getUserByUsername(username);
    }

    /**
     * 发布
     * @param question
     */
    @Override
    public void create(Question question) {
        questionMapper.insert(question);
    }

    /**
     * 根据token查询用户
     * @param token
     * @return
     */
    @Override
    public User queryUserByToken(String token) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(token);

        return userMapper.selectOneByExample(example);
    }

    @Override
    public PageDto getQuestionList(Integer page, Integer size) {
        Integer offset = size * (page - 1);

        List<QuestionDto> questionDtoList = new ArrayList<>();

        //查询每页显示的数据
        List<Question> questions = questionMapper.list(offset,size);

        PageDto pageDto = new PageDto();

        for (Question question : questions) {
            Integer id = question.getCreator();
            User user = userMapper.getUserByCreator(id);
            QuestionDto questionDto = new QuestionDto();
            BeanUtils.copyProperties(question,questionDto);
            questionDto.setUser(user);
            questionDtoList.add(questionDto);
        }

        Integer totalCount = questionMapper.count();
        pageDto.setQuestions(questionDtoList);
        pageDto.setPagination(totalCount,page,size);
        return pageDto;
    }

    @Override
    public Integer count() {
        return questionMapper.count();
    }
}
