package com.hunsy.pointshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hunsy.pointshop.mapper")
public class PointShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointShopApplication.class, args);
    }

}
