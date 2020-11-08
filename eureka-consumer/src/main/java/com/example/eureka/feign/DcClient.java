package com.example.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;


@Primary
@FeignClient(value = "api-gateway",fallback = FallbackClient.class)
public interface DcClient {
    @GetMapping("/eureka-testclient/dc")
    String consumer();
}
