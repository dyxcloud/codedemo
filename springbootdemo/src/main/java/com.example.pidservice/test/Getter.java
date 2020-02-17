package com.example.pidservice.test;

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
        System.out.println("bean1方法运行了");
        return new Getter();
    }

    @Bean
    public Getter getter2(){
        System.out.println("bean2方法运行了");
        return new Getter();
    }


    public Getter() {
        System.out.println("构造方法运行了");
    }
}
