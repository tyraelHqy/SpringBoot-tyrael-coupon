package com.tyrael.tyraelcoupon.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {

    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 线程池核心的线程数量，默认值为1，这就是SpringBoot默认线程池不能被重用的原因
        executor.setCorePoolSize(10);

        // 线程池维护的最大数量
        executor.setMaxPoolSize(20);

        // 缓冲队列任务的数量
        executor.setQueueCapacity(20);

        // 超出核心线程数的线程在空闲时的最大存活时间
        executor.setKeepAliveSeconds(60);

        // 线程名的前缀
        executor.setThreadNamePrefix("TyraelAsync_");

        // 是否等待所有线程执行完毕之后再去关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        // 默认的等待时长,设置为0意味着不等待
        executor.setAwaitTerminationSeconds(0);

        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();
        return executor;
    }

    /**
     * 定义异步任务异常处理类
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new AsyncExceptionHandler();
    }

    class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("AsyncError:{} , Method : {} , Param : {}",
                    throwable.getMessage(),
                    method.getName(),
                    JSON.toJSONString(objects));

            //TODO 发送邮件或者发送短信
        }
    }
}
