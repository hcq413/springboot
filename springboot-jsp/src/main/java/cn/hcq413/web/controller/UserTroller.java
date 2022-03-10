package cn.hcq413.web.controller;

import cn.hcq413.web.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class UserTroller {

    @GetMapping("/findUser")
    public ModelAndView findUser() {
        List<User> list = new LinkedList<>();
        list.add(new User("张三", "打篮球", 15));
        list.add(new User("李四", "打足球", 16));
        list.add(new User("王五", "打天球", 17));
        list.add(new User("张三1", "打篮球1", 18));
        ModelAndView mv = new ModelAndView();
        mv.addObject("User", list);
        mv.setViewName("index");
        return mv;

    }
}
