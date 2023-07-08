package com.example.spring_aop.service.impl;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 12:37
 * Package_name: com.example.spring_aop.service.impl
 * Description:  Version: V1.0
 * Comment Before See:
 */

@Component
public class GetDataFromRedis {
    //模拟数据来自于redis
    private Map<String,String> dataFromRedis = new HashMap<>();


    {
        dataFromRedis.put("queryData","我是来自于redis里面的数据!");

    }

    public Object getCache(String param){
        return dataFromRedis.get(param);
    }
}
