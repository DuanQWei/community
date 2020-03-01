package cn.duanqwei.community.dto;

import cn.duanqwei.community.bean.User;
import lombok.Data;

import java.util.Date;

@Data
public class QuestionDto {
    private Integer id;
    private String title;
    private String descrition;
    private Date createTime;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer starCount;
    private String tag;
    private User user;
}
