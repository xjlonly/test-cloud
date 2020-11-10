package com.example.eureka.eclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/dc")
    public String dc(HttpServletRequest request){
        logger.info("-------------------trace-2-----------------------------------------");
        logger.info("===<call trace-2, TraceId={}, SpanId={}>===",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        String services = "Services: " + discoveryClient.getServices();
        logger.info(services);
        return services;
    }

    @GetMapping("/service")
    public String getServiceName(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String services = "Services: " + discoveryClient.getServices();
        logger.info(services);
        return services;
    }

    @GetMapping("/health")
    public int health(){
        return 0;
    }

    @GetMapping("/info")
    public String info(){
        return "This is a eureka client";
    }

}
