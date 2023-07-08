package com.example.spring_aop.controller;

import com.example.spring_aop.entity.User;
import com.example.spring_aop.service.AutoCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 12:09
 * Package_name: com.example.spring_aop.controller
 * Description:  Version: V1.0
 * Comment Before See:
 */
@Controller
public class AutoCacheController {


    @Autowired
    private AutoCacheService autoCacheService;

    @ResponseBody
    @RequestMapping(value = "/testAutoCacheQuery", method = RequestMethod.GET)
    public Object testAutoCacheQuery(String param1,String param2){
        Object o = autoCacheService.autoCacheFromRedisOrDataBase(param1,param2);
        System.out.println(o);
        return o;
    }

    @ResponseBody
    @RequestMapping(value = "/testAutoCacheQueryByObject", method = RequestMethod.POST)
    public Object testAutoCacheQueryByObject(@RequestBody User user){
        Object o = autoCacheService.autoCacheFromRedisOrDataBaseByUser(user);
        System.out.println(o);
        return o;
    }
}
