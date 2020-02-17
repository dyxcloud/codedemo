package com.example.sbootdemo.test;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author DongYunxiang
 * @create 2020-02-17
 **/
@Service
public class Getter {

    @Bean
    public Getter getter1(){
        return new Getter();
    }

    @Bean
    public Getter getter2(){
        return new Getter();
    }

    public Getter() {
        System.out.println("构造方法运行了");
    }
}
