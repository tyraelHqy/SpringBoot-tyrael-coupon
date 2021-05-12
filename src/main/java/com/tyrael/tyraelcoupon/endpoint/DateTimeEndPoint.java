package com.tyrael.tyraelcoupon.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义事件端点
 */
@Endpoint(id = "datetime")
public class DateTimeEndPoint {

    private String format = "yyyy-MM-dd HH:mm:ss";
    /**
     * 用于显示监控指标
     * @return
     */
    @ReadOperation
    public Map<String,Object> info(){
        Map<String,Object> info = new HashMap<>();
        info.put("name","Tyrael");
        info.put("age","19");
        info.put("datetime",new SimpleDateFormat(format).format(new Date()));

        return info;
    }

    /**
     * 动态更改监控指标
     * @param format
     */
    @WriteOperation
    public void setFormat(String format){
        this.format = format;
    }
}
