package com.sfu.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        log.error("访问" + request.getRequestURI() + " 发生错误, 错误信息:" + ex.getMessage());
        ModelAndView error = new ModelAndView("error/error");
        error.addObject("exMsg", ex.getMessage());
        error.addObject("exType", ex.getClass().getSimpleName().replace("\"", "'"));
        return error;
    }
}
