package com.example.sbootdemo.controller;

import com.example.sbootdemo.dao.UserMapper;
import com.example.sbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//证明是controller并且返回json
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "cs")
    public User cs() {
        User user = userMapper.selectUserByName("admin");
        return user;
    }
}
