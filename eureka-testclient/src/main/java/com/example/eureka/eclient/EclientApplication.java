package com.example.eureka.eclient;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import zipkin.server.EnableZipkinServer;

//@EnableEurekaClient
@EnableZipkinServer
@EnableSwagger2Doc
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EclientApplication.class, args);
    }

}
