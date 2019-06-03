package com.ybzbcq.configuration;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局捕获异常
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
        return "服务器繁忙，请稍后重试，谢谢~";
    }
}
