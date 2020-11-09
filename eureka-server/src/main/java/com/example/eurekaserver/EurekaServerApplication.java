package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        String act = "server01";
        if(args.length > 0){
            act = args[0];
        }
        new SpringApplicationBuilder(EurekaServerApplication.class).profiles(act).run(args);
        //SpringApplication.run(EurekaServerApplication.class, args);
    }

}
