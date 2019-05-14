package com.example.sbootdemo.controller;

import com.example.sbootdemo.dao.UserMapper;
import com.example.sbootdemo.domain.Book;
import com.example.sbootdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController//证明是controller并且返回json
public class UserController {


    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "cs")
    public User cs(User u, Book book) {
        System.out.println(u+"=="+book.bookName);
        User user = userMapper.selectUserByName("admin");
        return user;
    }

    @RequestMapping(value = "hello")
    public @ResponseBody String hello(){
        return "hello world";
    }
}
