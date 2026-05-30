package org.example.gpt.controller;

import org.example.gpt.common.Result;
import org.example.gpt.entity.user;
import org.example.gpt.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class hellocontroller {

    @Autowired
    private userservice userservice;

    @GetMapping("/users")
    public Result<List<user>> list() {
        return Result.success(userservice.list());
    }
    @GetMapping("/user")
    public Result<user> get(String name) {

        return Result.success(userservice.get(name));
    }
    @PostMapping("/user")
    public Result add(@RequestBody user user) {

        userservice.add( user);
        return Result.success("添加成功") ;
    }
    @PostMapping("/login")
    public Result<String> login(String name, String password, HttpSession session) {
        user user = userservice.get(name);
        if (user == null) {
            return Result.error("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            return Result.error("密码错误");
        }

        session.setAttribute("user", name);
        return Result.success("登录成功");

    }
    @PostMapping("/register")
    public Result<String> register(String name, String password) {
        user user = userservice.get(name);
        if (user != null) {
            return Result.error("用户已存在");
        }
        user = new user();
        user.setName(name);
        user.setPassword(password);
        userservice.add(user);
        return Result.success("注册成功");
    }

}
