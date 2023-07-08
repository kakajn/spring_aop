package com.example.spring_aop.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 15:54
 * Package_name: com.example.spring_aop.exceptions
 * Description:  Version: V1.0
 * Comment Before See:
 */
public class ParamsNotCanStringifyException extends RuntimeException {

    private static final String EXCEPTION_INFO_PREFIX = "The annotation @CacheKey must use at basic or String or Wrapper data type Type but not ";

    @Override
    public String getMessage() {
        return EXCEPTION_INFO_PREFIX;
    }
}
