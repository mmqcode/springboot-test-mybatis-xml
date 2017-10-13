package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/9/1.
 */

@SpringBootApplication
@MapperScan("com.test.mapper")
public class AppConfig {
    public static void main(String[] args){
        SpringApplication.run(AppConfig.class);
    }
}