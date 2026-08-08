package org.example.gpt.intercepter;

import org.example.gpt.common.Result;
import org.example.gpt.entity.user;
import org.example.gpt.service.userservice;
import org.example.gpt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@Component
public class loginintercepter implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    userservice userservice;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String header= request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ") || header.length() <= 7) {

            response.setContentType(
                    "application/json;charset=UTF-8");

            response.getWriter().write("{\"msg\":\"缺少认证信息，请先登录\"}");
            return false;
        }

        String token=header.substring(7);
        Long userid=jwtUtils.parseToken(token);

        Long id = (Long) redisTemplate.opsForValue().get(token);

        if (id==null){

            response.setContentType(
                    "application/json;charset=UTF-8");
            response.getWriter().write("{\"msg\":\"认证过期，请重新登录\"}");
        }



        if (!id.toString().equals(userid.toString())) {

            response.setContentType(
                    "application/json;charset=UTF-8");

            response.getWriter().write(
                    "{\"msg\":\"请先登录\"}");

            System.out.println(token);
            System.out.println(id.toString());
            System.out.println(userid.toString());

            return false;
        }


            return true;


    }


}
