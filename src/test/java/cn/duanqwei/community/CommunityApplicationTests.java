package cn.duanqwei.community;

import cn.duanqwei.community.mapper.QuestionMapper;
import cn.duanqwei.community.mapper.UserMapper;
import cn.duanqwei.community.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {
    @Autowired
    private QuestionMapper questionMapper;


    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        String s = MD5Util.md5Encrypt32Lower("123456");
        System.out.println(s);
    }

    @Test
    void test01(){
        System.out.println(userMapper.queryImgUrl(4));
    }



}
