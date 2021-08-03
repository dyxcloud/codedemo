package com.example.sbootdemo.controller;

import com.example.sbootdemo.dao.UserMapper;
import com.example.sbootdemo.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController//证明是controller并且返回json
public class UserController {

    @Resource
    UserMapper userMapper;
    
    @RequestMapping(value = "cs")
    public User cs(@RequestBody User u) {
        System.out.println(u);
        return userMapper.selectUserByName("admin");
    }

    @RequestMapping(value = "hello")
    public @ResponseBody
    String hello() {
        return "hello world";
    }

    @RequestMapping(value = "newfile.txt")
    public @ResponseBody
    String file() {
        return "这是动态生成的";
    }
}
