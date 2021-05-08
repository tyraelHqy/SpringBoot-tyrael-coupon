package com.tyrael.tyraelcoupon.service;

import com.tyrael.tyraelcoupon.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 异步服务功能测试
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws InterruptedException{
        asyncService.asyncProcess();
        log.info("coming in testAsyncProcess...");
    }

    /**
     * 检测asyncProcessHasReturn方法，如果运行的时间超过了3s，则抛出TimeoutException
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    @Test
    public void testAsyncProcessHasReturn() throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();

        Future<Integer> result = asyncService.asyncProcessHasReturn();
//        log.info("get async task value: {}",result.get());

        log.info("get async task value: {}",result.get(3, TimeUnit.SECONDS));
        log.info("time for async task: {}ms",System.currentTimeMillis()-start);

    }
}
