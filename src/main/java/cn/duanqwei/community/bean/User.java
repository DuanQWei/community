package cn.duanqwei.community.bean;

import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Date createTime;
    private String token;
    private String avatarUrl;
}
