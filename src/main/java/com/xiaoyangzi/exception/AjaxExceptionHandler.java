package com.xiaoyangzi.exception;

import com.xiaoyangzi.util.LiuJSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liuyang
 * @Date: 20180430 18:09
 */
//@RestControllerAdvice
public class AjaxExceptionHandler {
    //@ExceptionHandler(value = Exception.class)
    public LiuJSONResult defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        e.printStackTrace();
        return LiuJSONResult.errorMsg(e.getMessage());
    }
}
