package com.tyrael.tyraelcoupon;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling 允许当前的应用开启定时任务
 * @EnableAsync 开启异步支持
 */

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class TyraelCouponApplication {

    public static void main(String[] args) {

        // 1. 通过静态的run方法，启动Springboot
		SpringApplication.run(TyraelCouponApplication.class, args);

        // 2. 通过Api调整应用行为
//		SpringApplication application = new SpringApplication(TyraelCouponApplication.class);
//		application.setBannerMode(Banner.Mode.OFF);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);

        // 3. SpringApplicationBuilder Fluent Api，链式调用
//        new SpringApplicationBuilder(TyraelCouponApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }

}
