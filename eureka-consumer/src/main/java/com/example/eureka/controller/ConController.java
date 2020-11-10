package com.example.eureka.controller;

import com.example.eureka.feign.DcClient;
import com.example.eureka.service.ConsumerService;
import com.example.eureka.service.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConController {

    @Autowired
    SinkSender sinkSender;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DcClient dcClient;

    @Autowired
    ConsumerService consumerService;
    @GetMapping("/sender")
    public boolean sender(){
        //sinkSender.sendSinkSenderTester();
        return true;
    }

    @GetMapping("/china/consumer")
    public String getdc(){
        //手动进行获取负载均衡服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("api-gateway");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/eureka-testclient/dc";
        logger.info("Consumer url : {}",url);
        //使用自动负载均衡时 不能使用ip地址访问 只能使用服务名访问 此处不使用依赖注入的bean
        return (new RestTemplate()).getForObject(url, String.class);
    }

    @GetMapping("/hystrix/test")
    public String hystrixTest(){
        return consumerService.consumerHystrix();
    }

    @GetMapping("/ribbon/consumer")
    public String getDcRibbon(){
        //通过ribbon进行负载均衡消费
        return  restTemplate.getForObject("http://api-gateway/eureka-testclient/dc", String.class);
    }

    @GetMapping("/tracenode")
    public String traceTest(){
        //通过ribbon进行负载均衡消费
        logger.info("---------------------------trace-1-----------------------------------------");
        return  restTemplate.getForObject("http://eureka-testclient1/dc", String.class);
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
