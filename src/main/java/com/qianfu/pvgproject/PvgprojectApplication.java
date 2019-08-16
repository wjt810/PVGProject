package com.qianfu.pvgproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qianfu.pvgproject.dao.*")
public class PvgprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PvgprojectApplication.class, args);
        System.out.println("首页进入地址：http://localhost:8888/index");
    }

}
