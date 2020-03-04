package cn.duanqwei.community.service.impl;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.mapper.QuestionMapper;
import cn.duanqwei.community.mapper.UserMapper;
import cn.duanqwei.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

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
    public List<QuestionDto> selectAllInfo() {

        return questionMapper.selectInfo();
    }


    @Override
    public Integer count() {
        return questionMapper.count();
    }


}
