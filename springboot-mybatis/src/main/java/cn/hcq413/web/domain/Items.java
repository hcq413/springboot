package cn.hcq413.web.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private Integer id;

    private String name;

    private Integer price;

    private String pic;

    private Date createtime;

    private String detail;
}