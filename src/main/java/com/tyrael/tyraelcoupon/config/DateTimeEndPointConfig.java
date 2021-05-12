package com.tyrael.tyraelcoupon.config;

import com.tyrael.tyraelcoupon.endpoint.DateTimeEndPoint;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义端点配置类
 */
@Configuration
public class DateTimeEndPointConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public DateTimeEndPoint dateTimeEndPoint(){
        return new DateTimeEndPoint();
    }
}
