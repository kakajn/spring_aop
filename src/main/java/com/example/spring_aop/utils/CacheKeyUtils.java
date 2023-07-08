package com.example.spring_aop.utils;

import com.example.spring_aop.enumeration.HowToGetCache;
import com.example.spring_aop.anno.CacheEntity;
import com.example.spring_aop.anno.CacheFiled;
import com.example.spring_aop.anno.CacheKey;
import com.example.spring_aop.exceptions.ParamsNotCanStringifyException;
import lombok.extern.slf4j.Slf4j;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 15:22
 * Package_name: com.example.spring_aop.aop_structure.utils
 * Description:  Version: V1.0
 * Comment Before See:
 */

@Slf4j
public class CacheKeyUtils {

    private static final String CACHE_PARAMETER_SEPARATOR = "#";

    /**
     *
     * @param param
     * @return
     * @throws IllegalAccessException
     */
    public static String getCacheKeyByEntity(Object param) throws IllegalAccessException {
        //创建StringBuilder 用于拼接查询缓存的key
        StringBuilder cacheKeyBuilder = new StringBuilder();

        Field[] declaredFields = param.getClass().getDeclaredFields();
        for (Field field : declaredFields){
            if (field.isAnnotationPresent(CacheFiled.class)){
                //设置可访问性, 使得可以获取私有属性的值
                field.setAccessible(true);
                // 获取属性的值
                Object value = field.get(param);
                if (!isBasicDataTypeOrItsWrapper(value)){
                    ParamsNotCanStringifyException paramsNotCanStringifyException = new ParamsNotCanStringifyException();
                    log.info(paramsNotCanStringifyException.getMessage());
                    throw paramsNotCanStringifyException;
                }else{
                    cacheKeyBuilder.append(field.getName());
                    cacheKeyBuilder.append(":");
                    cacheKeyBuilder.append(transATypeToString(value));
                    cacheKeyBuilder.append(CACHE_PARAMETER_SEPARATOR);
                }
            }
        }
        return cacheKeyBuilder.toString();
    }

    public static String getCacheKeyByParam(Method proxyMethod,Object[] args){
        //创建StringBuilder 用于拼接查询缓存的key
        StringBuilder cacheKeyBuilder = new StringBuilder();

        //获取方法参数的反射对象数组
        Parameter[] parameters = proxyMethod.getParameters();

        //遍历参数, 获取带有注解的参数的值
        //记录参数的长度
        int parametersLength = parameters.length;

        for (int i = 0; i<parametersLength; i++){
            if (parameters[i].isAnnotationPresent(CacheKey.class)){
                Object arg = args[i];
                //如果打上CacheKey注解的参数不是String类型的, 那么就抛出异常
                if (!(isBasicDataTypeOrItsWrapper(arg))){
                    ParamsNotCanStringifyException paramsNotCanStringifyException = new ParamsNotCanStringifyException();
                    log.info(paramsNotCanStringifyException.getMessage());
                    throw paramsNotCanStringifyException;
                }else{
                    cacheKeyBuilder.append(parameters[i].getName());
                    cacheKeyBuilder.append(":");
                    cacheKeyBuilder.append(transATypeToString(arg));
                    cacheKeyBuilder.append(CACHE_PARAMETER_SEPARATOR);
                }
            }
        }

        return cacheKeyBuilder.toString();
    }

    public static String generateCacheKeyByArrays(Object ... cacheKeys){
        StringBuilder cacheKeyStringBuild = new StringBuilder();
        for (Object cacheKey: cacheKeys){
            if (!isBasicDataTypeOrItsWrapper(cacheKey)){
                ParamsNotCanStringifyException paramsNotCanStringifyException = new ParamsNotCanStringifyException();
                log.info(paramsNotCanStringifyException.getMessage());
                throw paramsNotCanStringifyException;
            }else{
                cacheKeyStringBuild.append(cacheKey);
                cacheKeyStringBuild.append(CACHE_PARAMETER_SEPARATOR);
            }
        }
        return cacheKeyStringBuild.toString();
    }

    public static boolean isBasicDataTypeOrItsWrapper(Object param){
        return  param instanceof String   ||
                param instanceof Integer  ||
                param instanceof Long     ||
                param instanceof Float    ||
                param instanceof Byte     ||
                param instanceof Short    ||
                param instanceof Double;
    }

    public static String transATypeToString(Object param){
        if (param instanceof String){
            return (String) param;
        }else if (param instanceof Integer){
            return param.toString();
        }else if ( param instanceof Long){
            return param.toString();
        }else if (param instanceof Float){
            return param.toString();
        }else if (param instanceof Byte){
            return param.toString();
        }else if (param instanceof Short){
            return param.toString();
        }else if (param instanceof Double){
            return param.toString();
        }
        return  "";
    }

    public static HowToGetCache howToGetCache(Method method){
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters){
            if (parameter.isAnnotationPresent(CacheKey.class)){
                return HowToGetCache.BY_CACHE_KEY;
            }else if (parameter.isAnnotationPresent(CacheEntity.class)){
                return HowToGetCache.BY_CACHE_FILED;
            }
        }
        return HowToGetCache.BY_ARRAY;
    }

}
