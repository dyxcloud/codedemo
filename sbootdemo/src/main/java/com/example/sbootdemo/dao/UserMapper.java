package com.example.sbootdemo.dao;

import com.example.sbootdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// @Mapper  // 与启动器上的@MapperScan二选一
@Repository
public interface UserMapper {
    User selectUserByName(String name);
}
