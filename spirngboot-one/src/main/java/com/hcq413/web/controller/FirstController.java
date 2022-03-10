package com.hcq413.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class FirstController {

    @GetMapping("/findListByUser")
    public List<String> findListByUser(){
        List<String> list=new LinkedList<>();
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        return list;
    }
}
