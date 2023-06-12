package com.example.bookstore.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class MyExceptionHandler {
    public MyExceptionHandler() {
    }

  /*  @ExceptionHandler({Exception.class})
    @ResponseBody
    public Result error(HttpServletRequest req, HttpServletResponse resp, Exception e) {
    Result result=new Result();
    result.fail();
      return result;
    }*/

    @ExceptionHandler({CommonException.class})
    @ResponseBody
    public Result error(HttpServletRequest req, HttpServletResponse resp, CommonException e) {
        return e.getResult();
    }

    @ExceptionHandler({AgainLoginException.class})
    @ResponseBody
    public Result error(HttpServletRequest req, HttpServletResponse resp, AgainLoginException e) {
        Result result = new Result();
        return result.againLogins("未登录，或登录过期，请登录");
    }
}
