package com.example.pidservice.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SecondKill implements Runnable {
    @Override
    public void run() {
        test();
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    public void test(){
        System.out.println(redisConnectionFactory.getClass());
        String myk = stringRedisTemplate.opsForValue().get("myk");
        System.out.println(myk);
        stringRedisTemplate.multi();
    }
}
