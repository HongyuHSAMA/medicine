package com.design.interceptor;

import com.design.entity.Worker;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI = { "/login","/index"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //flag用于判断用户是否登录的，默认为false；
        boolean flag = false;
        //获取用户发起的请求的URL路径
        String requestUrl = request.getServletPath();

        //进行判断是否需要拦截
        for (String s : IGNORE_URI) {
            if (requestUrl.contains( s )) {
                flag = true;
                break;
            }
        }
        //拦截请求
        if (!flag) {
            Worker worker = (Worker) request.getSession().getAttribute( "worker" );
            if (worker == null) {
                request.setAttribute( "message", "请先登录再访问网站" );
                request.getRequestDispatcher( "login" ).forward( request, response );

            } else {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
