package com.ly.xiyifu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class ApplicationContextHolder implements DisposableBean, ApplicationContextAware {


    private static ApplicationContext applicationContext;


    private Logger log = LoggerFactory.getLogger(ApplicationContextHolder.class);


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (applicationContext.getEnvironment().getActiveProfiles().length > 0) {
            log.debug("the application context env is : " + applicationContext.getEnvironment().getActiveProfiles()[0]);
        }
        this.applicationContext = applicationContext;
    }


    public static <T> T getBean(Class<T> entityClass) {
        return applicationContext.getBean(entityClass);
    }

    public static <T> T getBean(String name, Class<T> entityClass) {
        return applicationContext.getBean(name, entityClass);
    }


    @Override
    public void destroy() throws Exception {
        this.applicationContext = null;
    }


}
