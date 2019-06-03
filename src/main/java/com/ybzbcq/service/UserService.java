package com.ybzbcq.service;

import com.ybzbcq.entity.UserEntity;
import com.ybzbcq.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Cacheable(cacheNames = "user")
public class UserService {
    @Autowired
    UserJPA userJPA;

    public List<UserEntity> list(){
        List<UserEntity> list = userJPA.findAll();
        return list;
    }


}
