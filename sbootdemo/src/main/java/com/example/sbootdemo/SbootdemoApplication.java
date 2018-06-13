package com.example.sbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 开启事务管理
@MapperScan("com.example.sbootdemo.dao") //与mapper的@mapper二选一
public class SbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootdemoApplication.class, args);
    }
}
