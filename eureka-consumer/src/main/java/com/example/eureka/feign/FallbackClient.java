package com.example.eureka.feign;

import org.springframework.stereotype.Component;

@Component
public class FallbackClient implements DcClient{
    @Override
    public String consumer() {
        return "fallback";
    }
}
