package com.tf.controller;

import com.tf.pojo.User;
import com.tf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        user.setSalt(Salt.generateSalt());
        boolean flag = service.Register(user);
        String msg = flag ? "注册成功" : "用户名重复，注册失败";
        return new Result(flag ? Code.REGISTER_OK:Code.REGISTER_ERR,flag,msg);
    }

    @PostMapping("login")
    public Result LogIn(@RequestBody User user){
        boolean flag = service.checkPassword(user);
        String msg = flag ? "密码正确" : "密码错误，请重新输入";
        return  new Result(flag ? Code.LOGIN_OK : Code.LOGIN_ERR,flag,msg);
    }

    @DeleteMapping("/{account}")
    public Result deleteUser(@PathVariable String account){
        boolean flag = service.DeletedUser(account);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
}
