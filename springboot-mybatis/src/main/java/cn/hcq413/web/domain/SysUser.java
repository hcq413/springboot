package cn.hcq413.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private String id;

    private String usercode;

    private String username;

    private String password;

    private String salt;

    private String locked;
}