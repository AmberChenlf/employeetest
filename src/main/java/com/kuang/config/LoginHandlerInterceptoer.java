package com.kuang.config;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器实现
public class LoginHandlerInterceptoer implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            request.setAttribute("msg","no user");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}

