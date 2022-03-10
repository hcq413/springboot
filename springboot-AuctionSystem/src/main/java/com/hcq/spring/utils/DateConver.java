package com.hcq.spring.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换
 *
 * @author 黄昌其
 * @date 2022/02/15
 */
@SuppressWarnings("all")
@Component
public class DateConver implements Converter<String, Date> {

    SimpleDateFormat[] sdf = {
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"),
            new SimpleDateFormat("yyyy/MM/dd"),
            new SimpleDateFormat("yyyy年MM月dd日"),
            new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒")
    };
    @Override
    public Date convert(String time) {
        for (int i = 0; i < sdf.length; i++) {
            try {
                return sdf[i].parse(time);
            } catch (ParseException e) {
                //e.printStackTrace();
                continue;
            }
        }
        return null;
    }
}