package com.sfu.interceptors;

import com.sfu.beans.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否公开地址（实际使用时将公开地址配置到配置文件中）
        //这里假设公开地址是否登陆提交的地址
        if(url.indexOf("/user") > 0) {
            //如果进行登陆提交，放行
            return true;
        }

        //判断session
        HttpSession session = request.getSession();
        //从session中取出用户身份信息
        User user = (User) session.getAttribute("user");
        if(user != null) {
            return true;
        }

        //执行到这里表示用户身份需要验证，跳转到登陆页面
        request.setAttribute("loginError","抱歉，您没有权限，请先登录");
        request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);

        return false;
    }
}
