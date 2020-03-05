package cn.duanqwei.community.controller;

import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.service.QuestionService;
import cn.duanqwei.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @RequestMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Integer id,
                           Model model){
        QuestionDto questionDto = questionService.getQuestionById(id);
        Integer userId = questionDto.getCreator();
        String username = userService.selectUsername(userId);
        model.addAttribute("username",username);
        model.addAttribute("questionDto",questionDto);
        return "question";
    }
}
