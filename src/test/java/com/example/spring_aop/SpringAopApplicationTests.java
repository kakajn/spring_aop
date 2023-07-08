package com.example.spring_aop;

import com.example.spring_aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest
class SpringAopApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {

    }

    @Test
    public void test(){
        userService.printlnUser();
        System.out.println(userService.getClass());
    }

}
