package com.hcq.spring.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;


@Slf4j
public class Myutils {

    /**
     * 打印错误
     *
     * @param obk 好
     */
    public static void printlnErr(Object... obk) {
        Stream.of(obk).forEach(System.err::println);
    }

    /**
     * 打印日志
     *
     * @param obk 好
     */
    public static void printlnLog(Object... obk) {
        Stream.of(obk).forEach(e->log.info(e.toString()));
    }

}