package com.example.debateteamos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< Updated upstream
=======
@MapperScan("com.example.debateteamos.mapper")
@SpringBootApplication
>>>>>>> Stashed changes
@MapperScan("com.example.debateteamos.mapper")
@SpringBootApplication
public class DebateTeamOsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebateTeamOsApplication.class, args);
    }

}
