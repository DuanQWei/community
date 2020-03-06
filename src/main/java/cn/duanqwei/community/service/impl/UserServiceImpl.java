package cn.duanqwei.community.service.impl;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.mapper.QuestionMapper;
import cn.duanqwei.community.mapper.UserMapper;
import cn.duanqwei.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @Override
    public User queryUserByToken(String token) {
        return userMapper.queryUserByToken(token);
    }


    @Override
    public List<QuestionDto> selectAllInfo() {

        return questionMapper.selectInfo();
    }

    @Override
    public void update(Integer id, String token) {
        userMapper.update(id,token);
    }

    @Override
    public String selectUsername(Integer id) {

        return userMapper.selectUsername(id);
    }

    @Override
    public String queryImgUrl(Integer id) {
        return userMapper.queryImgUrl(id);
    }


}
