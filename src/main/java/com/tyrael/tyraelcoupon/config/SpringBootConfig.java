package com.tyrael.tyraelcoupon.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * SpringBoot 的配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "imooc.springboot")

public class SpringBootConfig {
    private String version;

    private String name;
}
