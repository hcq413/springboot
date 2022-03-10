package cn.hcq413.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.hcq413.web.mapper")
public class Appstart {
    public static void main(String[] args) {
        SpringApplication.run(Appstart.class,args);
    }
}
