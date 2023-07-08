package com.example.spring_aop.service.impl;

import com.example.spring_aop.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/06/13 3:00
 * Package_name: com.example.spring_aop.service.impl
 * Description:  Version: V1.0
 * Comment Before See:
 */

@Component
public class UserServiceImpl implements UserService {

    @Override
    public void printlnUser() {
        System.out.println("被代理对象执行了!..........");
    }

    @Override
    public void findUser1() {
        System.out.println("findUser1");
    }

}
