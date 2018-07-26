package com.ly.xiyifu.cache.aop;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ly.xiyifu.cache.annotation.RedisCacheable;
import com.ly.xiyifu.utils.JsonMapper;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
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
import java.util.concurrent.TimeUnit;

/**
 * 文件名称： RedisCacheableAspect
 * <p>
 * 包路径： com.ly.platform.cache.aop
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/07/11 - 11:19
 * <p>
 * 修改记录：
 */
@Component
@Aspect
public class RedisCacheableAspect {

    private Logger log = LoggerFactory.getLogger(RedisCacheableAspect.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    private ObjectMapper jsonMapper = JsonMapper.jsonMapper;


    //切入点
    @Pointcut("execution(public * com.ly.xiyifu.dao.*.*(..))")
    public void cachePoint() {
    }

    @Around(value = "cachePoint()")
    public Object action(ProceedingJoinPoint pjp) throws Throwable {

        Signature signature = pjp.getSignature();

        //一般来讲这个注解就是加到方法上来用的

        Method method = ((MethodSignature) signature).getMethod();
        RedisCacheable redisCacheable = AnnotationUtils.getAnnotation(method, RedisCacheable.class);

        if (redisCacheable != null) {
            String key = redisCacheable.namespace() + RedisCacheKeyUtil.parseKey(redisCacheable.key(), pjp.getArgs());
            Class<?> returnType = method.getReturnType();
            String json = redisTemplate.opsForValue().get(key);
            if (StringUtils.isNotBlank(json)) {
                Object ret = null;
                try {
                    ret = jsonMapper.readValue(json, returnType);
                } catch (Exception e) {
                    log.error("redis cache error!!!", e);
                    log.error(json, e);

                    proceedAndSave(pjp, key, redisCacheable.expireTime());

                }

                return ret;
            } else {
                return proceedAndSave(pjp, key, redisCacheable.expireTime());
            }
        } else {
            return pjp.proceed();
        }


    }

    /**
     * *
     * 执行查询 并且保存结果
     */
    private Object proceedAndSave(ProceedingJoinPoint pjp, String key, int expireTime) throws Throwable {
        Object result = pjp.proceed();
        if (result != null) {
            redisTemplate.opsForValue().set(key, jsonMapper.writeValueAsString(result), expireTime, TimeUnit.SECONDS);
        }

        return result;

    }

}
