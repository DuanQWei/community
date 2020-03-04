package cn.duanqwei.community.controller;

import cn.duanqwei.community.dto.QuestionDto;
import cn.duanqwei.community.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
                         ) {


        PageHelper.startPage(pageNum, 5);
        List<QuestionDto> list = userService.selectAllInfo();
        PageInfo<QuestionDto> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "index";
    }

}
