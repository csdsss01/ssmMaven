package com.aaa.ssm;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aaa.ssm.dao")
public class SpringbootMainApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMainApp.class);
    }
}


