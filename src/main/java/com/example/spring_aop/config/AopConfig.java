package com.example.spring_aop.config;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/06/13 2:57
 * Package_name: com.example.spring_aop.config
 * Description:  Version: V1.0
 * Comment Before See:
 */

//@Component
//@Aspect
//public class AopConfig {
//
//    //配置service层, 以println开头的方法的切点
//    @Pointcut("execution (* com.example.spring_aop.service.UserService.println*(..))")
//    public void testPointcut(){
//
//    }
//
//    @Before("testPointcut()")
//    public void beforeAdvice(){
//        System.out.println("beforeAdvice........");
//    }
//
//    @After("testPointcut()")
//    public void afterAdvice(){
//        System.out.println("afterAdvice........");
//    }
//
//    @Around("testPointcut()")
//    public void aroundAdvice(){
//        System.out.println("aroundAdvice........");
//    }
//
//
//
//
//    //配置service层, 以find开头的切点
//    @Pointcut("execution (* com.example.spring_aop.service.UserService.find*(..))")
//    public void startWithFindInPackageServicePointcut(){
//
//    }
//
//    @Before("startWithFindInPackageServicePointcut()")
//    public void beforeAdviceToStartWithFindInPackageServicePointcut(){
//        System.out.println("beforeAdvice........");
//    }
//
//    @After("startWithFindInPackageServicePointcut()")
//    public void afterAdviceToStartWithFindInPackageServicePointcut(){
//        System.out.println("afterAdvice........");
//    }
//
//    @Around("startWithFindInPackageServicePointcut()")
//    public void aroundAdviceToStartWithFindInPackageServicePointcut(){
//        System.out.println("aroundAdvice........");
//    }
//
//
//
//
//
//
//
//    //配置controller层的切面
//    @Pointcut("execution (* com.example.spring_aop.controller.*.*(..))")
//    public void testPointcut1(){
//
//    }
//
//    @Around("testPointcut1()")
//    public void aroundAdviceController(){
//        System.out.println("aroundAdviceController........");
//    }
//}
