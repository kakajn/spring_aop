package com.example.spring_aop.entity;

import com.example.spring_aop.anno.CacheFiled;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 17:26
 * Package_name: com.example.spring_aop.entity
 * Description:  Version: V1.0
 * Comment Before See:
 */
@Data
public class User {

    @CacheFiled
    private String userName;

    @CacheFiled
    private Integer userAge;

    @CacheFiled
    private String userHobbit;
}
