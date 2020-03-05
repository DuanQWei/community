package cn.duanqwei.community.controller;

import cn.duanqwei.community.bean.User;
import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value = "/profile/{action}",method = RequestMethod.GET)
    public String profile(
            @PathVariable(name = "action") String action,
            Model model,
            HttpServletRequest request,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ){
        User user = (User) request.getSession().getAttribute("user");

        if(user == null){
            return "redirect:/toLogin";
        }
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if("repies".equals(action)){
            model.addAttribute("section","repies");
            model.addAttribute("sectionName","最新回复");
        }

        PageHelper.startPage(pageNum,5);
        List<QuestionDto> questionList = questionService.list(user.getId());
        PageInfo<QuestionDto> questionPageInfo = new PageInfo<>(questionList);
        model.addAttribute("questionPageInfo",questionPageInfo);
        return "profile";
    }
}
