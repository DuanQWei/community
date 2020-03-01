package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.service.UserService;
import cn.duanqwei.community.util.MD5Util;
import com.fasterxml.jackson.core.SerializableString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Model model,
                        HttpServletRequest request){

        User user = userService.queryUserByname(username);
        String s = MD5Util.md5Encrypt32Lower(password);
        if(user == null){
            model.addAttribute("text","该用户不存在");
        }
        if (user.getPassword().equals(s)){
           request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }
    }

    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }

}
