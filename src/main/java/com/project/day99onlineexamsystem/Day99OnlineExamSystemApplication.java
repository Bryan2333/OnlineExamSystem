package com.project.day99onlineexamsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.day99onlineexamsystem.dao")
public class Day99OnlineExamSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(Day99OnlineExamSystemApplication.class, args);
    }
}
