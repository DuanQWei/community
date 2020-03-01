package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.service.UserService;
import cn.duanqwei.community.util.MD5Util;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        String s = MD5Util.md5Encrypt32Lower(password);
        User user = new User();
        user.setPassword(s);
        user.setUsername(username);
        user.setCreateTime(new Date());
        String token = UUID.randomUUID().toString().replaceAll("-","");
        user.setToken(token);
        userService.insert(user);
        response.addCookie(new Cookie("token",token));
        return "redirect:/";
    }
}
