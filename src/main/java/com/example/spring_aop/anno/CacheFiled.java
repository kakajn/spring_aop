package com.example.spring_aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 15:20
 * Package_name: com.example.spring_aop.config.anno
 * Description:  Version: V1.0
 * Comment Before See:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CacheFiled {
}
