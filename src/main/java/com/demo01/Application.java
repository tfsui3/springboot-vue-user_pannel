package com.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//spring boot 工程中都有个引导类，这是工程入口类
@SpringBootApplication
//扫描mybatis所有的业务mapper接口,
//@MapperScan("com.demo01.mapper") //@MapperScan Mybatis官方扫描
@MapperScan("com.demo01.mapper") //通用mapperScan
@org.mybatis.spring.annotation.MapperScan("com.demo01.mybatis_mapper") //mybatis mapperScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
