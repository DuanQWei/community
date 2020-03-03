package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.Question;
import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class PublishController {

    @Autowired
    private UserService userService;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @RequestMapping("/doPublish")
    public String doPublish(
            @RequestParam("title")String title,
            @RequestParam("description")String description,
            @RequestParam("tag")String tag,
            HttpServletRequest request,
            Model model
    ){
        Question question = new Question();
        question.setTitle(title);
        question.setDescrition(description);
        question.setTag(tag);
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","用户未登录");
            return "login";
        }
        question.setCreator(user.getId());
        question.setCreateTime(new Date());
        userService.create(question);
        return "redirect:/";
    }
}
