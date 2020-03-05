package cn.duanqwei.community.mapper;

import cn.duanqwei.community.bean.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User> {

     User queryUserByToken(@Param("token") String token);

    User getUserByCreator(@Param("creator")Integer creator);

    User getUserByUsername(@Param("username")String username);


    User selectById(@Param("id") Integer id);


    void update(@Param("id") Integer id,@Param("token") String token);

    String selectUsername(@Param("id")Integer id);
}
