package org.example.gpt.controller;

import org.example.gpt.common.Result;
import org.example.gpt.entity.user;
import org.example.gpt.service.userservice;
import org.example.gpt.utils.JwtUtils;
import org.example.gpt.vo.loginvo;
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
    private loginvo loginvo;

    @Autowired
    private JwtUtils jwtUtils;

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
    public Result login(String name, String password, HttpSession session) {




        user user = userservice.get(name);
        if (user == null) {
            return Result.error("用户不存在");
        }
        if (!user.getPassword().equals(password)) {
            return Result.error("密码错误");
        }

        String token = jwtUtils.createjwt((long)user.getid());

        loginvo loginvo = new loginvo();
        loginvo.setMsg("登录成功");
        loginvo.setToken(token);


        return Result.success(loginvo);

    }




    @PostMapping("/register")
    public Result<String> register(String name, String password) {

        if (name==null||password==null||name.trim().isEmpty()||password.trim().isEmpty()){
            return Result.error("用户名或密码不能为空");
        }


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
