package com.tyrael.tyraelcoupon.controller;

import com.tyrael.tyraelcoupon.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试Controller
 */
@Slf4j
@RestController
@RequestMapping("/springboot")
public class HelloController {

    @Autowired
    private SpringBootConfig springBootConfig;

    @Value("${imooc.springboot.version}")
    private String version;

    @Value("${imooc.springboot.name}")
    private String name;

    /**
     * 第一种方式的数据注入
     * localhost:8000/imooc/springboot/conf_inject_1
     */
    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("First conf inject:version is {}, name is {}",version,name);
    }

    /**
     * 第二种方式的数据注入
     * localhost:8000/imooc/springboot/conf_inject_2
     */
    @GetMapping("/conf_inject_2")
    public void secondConfInject(){
        log.info("Second conf inject:version is {}, name is {}",springBootConfig.getVersion(),springBootConfig.getName());
    }


}
