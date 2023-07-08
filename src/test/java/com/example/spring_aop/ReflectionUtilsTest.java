package com.example.spring_aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 15:34
 * Package_name: com.example.spring_aop
 * Description:  Version: V1.0
 * Comment Before See:
 */
public class ReflectionUtilsTest {
}

class AnnotationReflectionExample {

    public static void main(String[] args) throws NoSuchMethodException {
        // 获取目标方法的反射对象
        Method method = MyClass.class.getMethod("myMethod", String.class, int.class);

        // 获取方法参数的反射对象数组
        Parameter[] parameters = method.getParameters();

        // 遍历参数，根据注解决定是否使用参数
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(UseParameter.class)) {
                // 参数带有注解，使用该参数
                System.out.println("Using parameter: " + parameter.getName());
            } else {
                // 参数没有注解，不使用该参数
                System.out.println("Ignoring parameter: " + parameter.getName());
            }
        }
    }

    static class MyClass {
        public void myMethod(@UseParameter String str, int num) {
            // 方法体
        }
    }

    @interface UseParameter {
        // 注解定义
    }
}