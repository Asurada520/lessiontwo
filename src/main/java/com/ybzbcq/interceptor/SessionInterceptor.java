package com.ybzbcq.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean loginFlag = request.getRequestURI().equals("/user/login");
        boolean loginViewFlag = request.getRequestURI().equals("/user/loginView");

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        if(loginFlag || loginViewFlag){
            return true;
        }

        Object session_user = request.getSession().getAttribute("_session_user"); //_session_user
        if(session_user == null){
            response.sendRedirect("/user/loginView");
            return false;
        }

        return true;
    }
}
