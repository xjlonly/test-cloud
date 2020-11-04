package com.example.eureka.controller;

import com.example.eureka.feign.DcClient;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DcClient dcClient;

    @GetMapping("/china/consumer")
    public String getdc(){
        //手动进行获取负载均衡服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        logger.info("Consumer url : {}",url);
        return  restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/ribbon/consumer")
    public String getDcRibbon(){
        //通过ribbon进行负载均衡消费
        return  restTemplate.getForObject("http://eureka-client/dc", String.class);
    }


    @GetMapping("/feign/consumer")
    public String getDcFeign(){
        //通过feign进行负载均衡消费 由于Feign是基于Ribbon实现的，所以它自带了客户端负载均衡功能
        return  dcClient.consumer();
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
