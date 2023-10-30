package com.example.numpySpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class NumpySpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumpySpringApplication.class, args);
    }

}
