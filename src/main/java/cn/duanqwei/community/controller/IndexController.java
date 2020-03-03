package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.PageDto;
import cn.duanqwei.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size){
        Cookie[] cookies = request.getCookies();
        if(cookies != null && cookies.length !=0){
            for (Cookie cookie : cookies) {
                if("token".equals(cookie.getValue())){
                    String token = cookie.getValue();
                    User user = userService.queryUserByToken(token);
                    if(user != null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
            //查询数据
            PageDto pageList = userService.getQuestionList(page,size);
            model.addAttribute("pageList",pageList);
        }
        return "index";
    }
}
