package com.example.spring_aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 11:52
 * Package_name: com.example.spring_aop.config.anno
 * Description:  Version: V1.0
 * Comment Before See:
 */

/**
 * Java中的元注解是用于注解其他注解的特殊注解。以下是Java中的元注解列表：
 *
 * @Retention：指定被注解的注解保留的时期，有三个取值：
 * RetentionPolicy.SOURCE：注解仅保留在源代码中，编译后不包含在字节码中。
 * RetentionPolicy.CLASS：注解保留在字节码中，但在运行时不可通过反射访问。
 * RetentionPolicy.RUNTIME：注解保留在字节码中，并在运行时可通过反射访问。
 *
 * @Target：指定被注解的注解可以应用的目标元素类型，可以是一个或多个目标类型，包括：
 * ElementType.TYPE：类、接口或枚举
 * ElementType.FIELD：字段
 * ElementType.METHOD：方法
 * ElementType.PARAMETER：方法参数
 * ElementType.CONSTRUCTOR：构造函数
 * ElementType.LOCAL_VARIABLE：局部变量
 * ElementType.ANNOTATION_TYPE：注解类型
 * ElementType.PACKAGE：包
 * @Documented：指定被注解的注解是否包含在Java文档中。
 *
 * @Inherited：指定被注解的注解是否可以被继承。
 *
 * 除了上述元注解，Java还提供了其他非元注解，用于在自定义注解中使用。一些常用的非元注解包括：
 *
 * @Deprecated：标记已过时的元素。
 * @Override：标记方法重写父类的注解。
 * @SuppressWarnings：抑制编译器警告。
 * @SafeVarargs：标记可变参数方法中的安全使用注解。
 * @FunctionalInterface：标记接口为函数式接口。
 * 这些元注解和非元注解提供了灵活性和控制力，用于定义和处理自定义注解的行为。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoQueryCache {
}
