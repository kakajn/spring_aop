package com.example.spring_aop.service.impl;

import com.example.spring_aop.anno.AutoQueryCache;
import com.example.spring_aop.anno.CacheEntity;
import com.example.spring_aop.anno.CacheKey;
import com.example.spring_aop.entity.User;
import com.example.spring_aop.service.AutoCacheService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 12:11
 * Package_name: com.example.spring_aop.service.impl
 * Description:  Version: V1.0
 * Comment Before See:
 */
@Service
public class AutoCacheServiceImpl implements AutoCacheService {



    //模拟数据来自于mysql
    private Map<String,String> dataFromMysql = new HashMap<>();

    {
        dataFromMysql.put("queryData","我是来自于Mysql里面的数据!");
    }


    @Override
    @AutoQueryCache
    public Object autoCacheFromRedisOrDataBase(@CacheKey String param1, @CacheKey String param2) {
        return dataFromMysql.get(param1);
    }

    @Override
    @AutoQueryCache
    public Object autoCacheFromRedisOrDataBaseByUser(@CacheEntity User user) {
        return "从数据库里面查询出数据";
    }
}
