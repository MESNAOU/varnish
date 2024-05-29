package com.microservice.metier_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MiroserviceMetierApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiroserviceMetierApplication.class, args);
    }

}
