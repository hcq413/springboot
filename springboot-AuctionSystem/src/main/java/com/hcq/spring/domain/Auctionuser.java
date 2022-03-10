package com.hcq.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auctionuser {
    /**
     * 用户表
     */
    private Integer userid;

    @Size(min = 3, max = 8, message = "{user.username.length.error}")
    private String username;

    @Size(min = 6, message = "{user.password.length.error}")
    private String userpassword;

    @Pattern(regexp = "\\d{18}", message = "{user.usercardno.format.error}")
    private String usercardno;

    private String usertel;

    private String useraddress;

    private String userpostnumber;

    private Integer userisadmin;

    private String userquestion;

    private String useranswer;
}