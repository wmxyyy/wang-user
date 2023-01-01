package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class WangUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(WangUserApplication.class, args);
    }

}
