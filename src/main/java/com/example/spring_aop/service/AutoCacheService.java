package com.example.spring_aop.service;

import com.example.spring_aop.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 12:10
 * Package_name: com.example.spring_aop.service
 * Description:  Version: V1.0
 * Comment Before See:
 */
public interface AutoCacheService {

     Object autoCacheFromRedisOrDataBase(String param,String param2);

     Object autoCacheFromRedisOrDataBaseByUser(User user);
}
