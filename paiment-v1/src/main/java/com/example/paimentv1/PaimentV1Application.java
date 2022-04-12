package com.example.paimentv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients("com.example.paimentv1.ws.required.facade")
@EnableEurekaClient
public class PaimentV1Application {

    public static void main(String[] args) {
        SpringApplication.run(PaimentV1Application.class, args);
    }

}
