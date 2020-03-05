package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.service.UserService;
import cn.duanqwei.community.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Model model,
                        HttpServletRequest request,
                        HttpServletResponse response){
        if(StringUtils.isEmpty(username)){
            model.addAttribute("msg", "用户名不能为空");
            return "login";
        }
        if(StringUtils.isEmpty(password)){
            model.addAttribute("msg", "密码不能为空");
            return "login";
        }
        if(!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)) {

            User user = userService.queryUserByname(username);
            if(user == null){
                model.addAttribute("msg", "用户名不存在");
                return "login";
            }
            String s = MD5Util.md5Encrypt32Lower(password);
            if (user.getPassword().equals(s)) {
                String token = UUID.randomUUID().toString().replaceAll("-","");
                user.setToken(token);
                Integer id = user.getId();
                userService.update(id,token);
                response.addCookie(new Cookie("token",token));
                request.getSession().setAttribute("user", user);
                return "redirect:/";
            } else {
                model.addAttribute("msg", "密码错误");
                return "login";
            }
        }else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "login";
        }
    }

    @RequestMapping("/toLogin")
    public String login(){
        return "login";
    }

}
