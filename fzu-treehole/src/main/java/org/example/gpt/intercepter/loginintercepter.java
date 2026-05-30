package org.example.gpt.intercepter;

import org.example.gpt.common.Result;
import org.example.gpt.entity.user;
import org.example.gpt.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class loginintercepter implements HandlerInterceptor {

    @Autowired
    userservice userservice;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        HttpSession session=request.getSession();
        String name = (String)session.getAttribute("user");

        if (name == null) {

            response.setContentType(
                    "application/json;charset=UTF-8");

            response.getWriter().write(
                    "{\"msg\":\"请先登录\"}");

            return false;
        }

        // 用户不存在
        if (userservice.get(name) == null) {

            response.setContentType(
                    "application/json;charset=UTF-8");

            response.getWriter().write(
                    "{\"msg\":\"用户不存在，请重新登录\"}");

            return false;
        }
            return true;


    }


}
