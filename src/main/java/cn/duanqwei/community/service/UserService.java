package cn.duanqwei.community.service;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.PageDto;

public interface UserService {
    //注册用户
    public void insert(User user);
    //根据用户名查询用户
    public User queryUserByname(String username);

    //发起一个问题
    public void create(Question question);

    //根据token查询用户
    public User queryUserByToken(String token);

    //查询所有的问题
    public PageDto getQuestionList(Integer page, Integer size);
    //查询问题的个数
    public Integer count();
}
