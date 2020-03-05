package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.service.UserService;
import cn.duanqwei.community.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(
            @RequestParam("username")String username,
            @RequestParam("password")String password
    ){
        String s = MD5Util.md5Encrypt32Lower(password);
        User user = new User();
        user.setPassword(s);
        user.setUsername(username);
        user.setCreateTime(new Date());
        userService.insert(user);
        return "redirect:/";
    }
}
