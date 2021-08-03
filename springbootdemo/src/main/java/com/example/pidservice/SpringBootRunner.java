package com.example.pidservice;

import com.example.pidservice.redis.SecondKill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;


@SpringBootApplication
public class SpringBootRunner implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunner.class, args);
    }


    @Resource
    SecondKill secondKill;

    public void run(String... args) {
        secondKill.run();
    }


}
