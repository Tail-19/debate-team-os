package com.example.debateteamos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.InitialContext;
import java.util.Properties;


@MapperScan("com.example.debateteamos.mapper")
@SpringBootApplication
public class DebateTeamOsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DebateTeamOsApplication.class, args);

    }
}
