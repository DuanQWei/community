package cn.duanqwei.community;

import cn.duanqwei.community.util.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
        String s = MD5Util.md5Encrypt32Lower("123456");
        System.out.println(s);
    }

}
