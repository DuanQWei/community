package cn.duanqwei.community.service;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.QuestionDto;

import java.util.List;

public interface UserService {
    //注册用户
    public void insert(User user);
    //根据用户名查询用户
    public User queryUserByname(String username);



    //根据token查询用户
    public User queryUserByToken(String token);








    //查询出来所有的问题和图像
    List<QuestionDto> selectAllInfo();

    //更新数据库
    void update(Integer id,String token);

    String selectUsername(Integer id);

    //根据id查询出来头像
    String queryImgUrl(Integer id);
}
