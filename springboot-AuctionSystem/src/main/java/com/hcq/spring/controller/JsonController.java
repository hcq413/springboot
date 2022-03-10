package com.hcq.spring.controller;


import com.hcq.spring.domain.Item;
import com.hcq.spring.utils.Myutils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @RequestMapping(value = "/requsetJson",method = RequestMethod.POST)
    @ResponseBody
    public Item requsetJson(@RequestBody Item item){
        Myutils.printlnLog(item.getName());
        Myutils.printlnLog(item.getPrice());
        return item;
    }
    @RequestMapping(value = "/requsetZhenJson",method = RequestMethod.POST)
    @ResponseBody
    public Item ItemrequsetZhenJson(Item item){
        Myutils.printlnLog(item.getName());
        Myutils.printlnLog(item.getPrice());
        return item;
    }


}
