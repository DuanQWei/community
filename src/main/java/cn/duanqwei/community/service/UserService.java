package cn.duanqwei.community.service;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.QuestionDto;

import java.util.List;

public interface UserService {
    //注册用户
    public void insert(User user);
    //根据用户名查询用户
    public User queryUserByname(String username);

    //发起一个问题
    public void create(Question question);

    //根据token查询用户
    public User queryUserByToken(String token);

    //查询问题的个数
    public Integer count();






    //查询出来所有的问题和图像
    List<QuestionDto> selectAllInfo();

}
