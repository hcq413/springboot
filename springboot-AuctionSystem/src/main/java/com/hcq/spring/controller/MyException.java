package com.hcq.spring.controller;


import com.hcq.spring.utils.AuctionPriceException;
import com.hcq.spring.utils.Myutils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyException {

    @ExceptionHandler(AuctionPriceException.class)
    public ModelAndView printStackTrace(Exception e){
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        Myutils.printlnLog(e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
