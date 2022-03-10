package cn.hcq413.web.controller;

import cn.hcq413.web.service_impl.itemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsController {

    @Autowired
    itemServiceImpl item;

    @GetMapping("/findUser")
    public ModelAndView findUser() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("Items", item.getAll());
        mv.setViewName("index");
        return mv;
    }
}
