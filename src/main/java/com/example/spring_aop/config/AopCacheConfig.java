package com.example.spring_aop.config;

import com.example.spring_aop.enumeration.HowToGetCache;
import com.example.spring_aop.utils.CacheKeyUtils;
import com.example.spring_aop.service.impl.GetDataFromRedis;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: kakajn
 * Date: 2023/07/08 11:50
 * Package_name: com.example.spring_aop.config
 * Description:  Version: V1.0
 * Comment Before See:
 */

@Component
@Aspect
public class AopCacheConfig {

    @Autowired
    private GetDataFromRedis getDataFromRedis;

    @Around("@annotation(com.example.spring_aop.anno.AutoQueryCache)")
    public Object existAutoQueryCache(ProceedingJoinPoint joinPoint) throws Throwable {
        //通过joinPoint对象获取方法签名
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        //通过方法签名获取方法对象
        Method proxyMethod = methodSignature.getMethod();
        //获取joinPoint里面带有的参数
        /**
         * 如果要支持多种参数的话: 比如
         * 1.零散的参数:
         * 2.参数全部封装到一个对象中: 这个对象有可能是List对象, 可能是Map对象, 可能是自定义的entity对象
         */
        //生成的 cacheKey
        String cacheKey = null;

        //判断如何获取cacheKey参数
        HowToGetCache howToGetCache = CacheKeyUtils.howToGetCache(proxyMethod);
        //参数
        Object[] args = joinPoint.getArgs();
        if (howToGetCache.equals(HowToGetCache.BY_CACHE_KEY)){
            cacheKey = CacheKeyUtils.getCacheKeyByParam(proxyMethod, args);
        }else if (howToGetCache.equals(HowToGetCache.BY_CACHE_FILED)){
            cacheKey = CacheKeyUtils.getCacheKeyByEntity(args[0]);
        }

        //判断从redis里面获取缓存数据为不为null, 或者是""空字符串
        Object cache = getDataFromRedis.getCache(cacheKey);
        //如果缓存为null 或者是 ""
        if (cache == null || "".equals(((String)cache))){
            //那么就应该继续让这个行为走下去 即: 查询数据库
            return joinPoint.proceed();
            /**
             * 但是这里应该注意一下, 不应该直接返回, 而是返回之前, 把数据更新到缓存里面
             * 这个操作最好是异步的, 这样的话效率好一点点
             */
        }else{
            return cache;
        }
    }
}
