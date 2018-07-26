package com.ly.xiyifu.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



/**
 * 文件名称： SpringMvcConfig
 * <p>
 * 包路径： com.ly.xiyifu.config
 * <p>
 * 版权所有：灵铱科技
 * <p>
 * 类描述：jackson scala扩展
 * <p>
 * 创建人： 程增辉
 * <p>
 * 创建时间： 2018/06/11 - 09:23
 * <p>
 * 修改记录：
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {
    @Value("${mode}")
    private String mode;

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(objectMapper());
    }


    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return mapper;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        super.addFormatters(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (mode.equals("dev")) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowCredentials(true)
                    .allowedHeaders("*")
                    .allowedMethods("GET", "POST", "DELETE", "PUT");
        }
    }
}
