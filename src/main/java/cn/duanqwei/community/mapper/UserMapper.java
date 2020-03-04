package cn.duanqwei.community.mapper;

import cn.duanqwei.community.bean.User;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User> {

    User getUserByCreator(Integer creator);

    User getUserByUsername(String username);


    User selectById(Integer id);



}
