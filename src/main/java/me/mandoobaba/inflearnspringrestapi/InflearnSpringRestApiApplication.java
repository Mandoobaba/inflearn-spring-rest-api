package me.mandoobaba.inflearnspringrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class InflearnSpringRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(InflearnSpringRestApiApplication.class, args);
    }

}
