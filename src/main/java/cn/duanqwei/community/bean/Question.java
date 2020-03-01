package cn.duanqwei.community.bean;

import lombok.Data;

import java.util.Date;


@Data
public class Question {
    private Integer id;
    private String title;
    private String descrition;
    private Date createTime;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer starCount;
    private String tag;

}
