package com.imooc.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//启动类
@SpringBootApplication
@EnableFeignClients
public class CoursePriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursePriceApplication.class,args);
    }
}
