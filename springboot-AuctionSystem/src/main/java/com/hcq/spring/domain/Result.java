package com.hcq.spring.domain;

import lombok.Data;

//json响应类
@Data
public class Result {
    private String message;
    private Object data;
}
