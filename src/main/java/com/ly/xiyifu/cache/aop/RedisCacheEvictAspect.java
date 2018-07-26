package com.ly.xiyifu.cache.aop;


import com.ly.xiyifu.cache.annotation.RedisCacheEvict;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 文件名称： RedisCacheEvictAspect
 * <p>
 * 包路径： com.ly.platform.cache.aop
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/11 - 15:14
 * <p>
 * 修改记录：
 */
@Component
@Aspect
public class RedisCacheEvictAspect {
    private Logger logger = LoggerFactory.getLogger(RedisCacheEvictAspect.class);
    @Autowired
    private RedisTemplate redisTemplate;

    //切入点
    @Pointcut("execution(public * com.ly.xiyifu.dao.*.*(..))")
    public void cachePoint() {

    }

    @Around(value = "cachePoint()")
    public Object action(ProceedingJoinPoint pjp) throws Throwable {
        Object result = pjp.proceed();
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        RedisCacheEvict RedisCacheEvict = AnnotationUtils.getAnnotation(method, RedisCacheEvict.class);
        if (RedisCacheEvict != null) {
            String key = RedisCacheEvict.namespace() + RedisCacheKeyUtil.parseKey(RedisCacheEvict.key(), pjp.getArgs());

            try {
                redisTemplate.delete(key);
            } catch (Exception e) {
                logger.error("-- del redis cache  error . key is:" + key, e);
            }
        }

        return result;

    }

}
