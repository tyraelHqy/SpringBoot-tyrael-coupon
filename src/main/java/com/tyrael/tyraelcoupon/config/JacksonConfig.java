package com.tyrael.tyraelcoupon.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * Jackson的配置
 */
@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper getObjectMapper(){

        ObjectMapper mapper = new ObjectMapper();
        /**
         * Json中不会存在value为NULL的key
         */
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        return mapper;
    }
}
