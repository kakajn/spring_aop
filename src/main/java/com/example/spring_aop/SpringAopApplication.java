package com.example.spring_aop;

import com.example.spring_aop.controller.UserController;
import com.example.spring_aop.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringAopApplication {

//    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run(SpringAopApplication.class, args);
//        UserService userService = run.getBean(UserService.class);
//        if (userService != null){
//            userService.printlnUser();
//        }
//    }

        public static void main(String[] args) {
            SpringApplication.run(SpringAopApplication.class, args);
        }

}
