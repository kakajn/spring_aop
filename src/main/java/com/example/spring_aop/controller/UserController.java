package com.example.spring_aop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/06/13 4:11
 * Package_name: com.example.spring_aop.controller
 * Description:  Version: V1.0
 * Comment Before See:
 */
@Controller
public class UserController {

    public void userController(){
        System.out.println("userController");
    }

}
