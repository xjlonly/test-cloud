package com.example.eureka.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerService {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(getClass());

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumerHystrix(){
       var serviceInstance = loadBalancerClient.choose("api-gateway");
       String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/eureka-testclient" +
               "/service";
       logger.info("hystrix service: {}", url);
        return (new RestTemplate()).getForObject(url, String.class);
    }

    private  String fallback(){
        return "fallback";
    }
}
