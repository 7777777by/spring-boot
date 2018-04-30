package com.xiaoyangzi.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: liuyang
 * @Date: 20180430 17:55
 */
@ControllerAdvice
public class CommonExceptionHandler {
    public static final String ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }
}
