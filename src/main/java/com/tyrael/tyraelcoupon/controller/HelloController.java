package com.tyrael.tyraelcoupon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyrael.tyraelcoupon.config.SpringBootConfig;
import com.tyrael.tyraelcoupon.vo.Worker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;


/**
 * 测试Controller
 */
@Slf4j
@RestController
@RequestMapping("/springboot")
public class HelloController {

    /**
     * SpringBoot config
     */
    private final SpringBootConfig springBootConfig;

    /**
     * ObjectMapper
     */
    private final ObjectMapper objectMapper;

    @Value("${imooc.springboot.version}")
    private String version;

    @Value("${imooc.springboot.name}")
    private String name;

    @Autowired
    public HelloController(SpringBootConfig springBootConfig, ObjectMapper objectMapper) {
        this.springBootConfig = springBootConfig;
        this.objectMapper = objectMapper;
    }

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

    /**
     * localhost:8000/imooc/springboot/jackson
     * @return
     */
    @GetMapping("/jackson")
    public Worker jackson() throws IOException {
        Worker build = Worker.builder().name("Tyrael").address("Wu").age(19).registTime(new Date()).build();

        /**
         * Jackson序列化
         */
        String jsonWorker = objectMapper.writeValueAsString(build);

        log.info("Worker Jackson: {}", jsonWorker);

        /**
         * Jackson反序列化
         */
        return objectMapper.readValue(jsonWorker,Worker.class);
    }

}
