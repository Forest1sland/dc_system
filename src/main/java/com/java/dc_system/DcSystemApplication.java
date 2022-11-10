package com.java.dc_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java.dc_system.dao")
public class DcSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DcSystemApplication.class, args);
    }

}
