package cn.hcq413.web.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class TUser {

    private Integer id;

    private String userName;

    private String password;

    private Date lastLoginTime;

    private Byte sex;
}

