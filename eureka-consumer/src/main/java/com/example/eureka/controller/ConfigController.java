package com.example.eureka.controller;

import com.example.eureka.GitAutoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
    @Autowired
    private GitAutoConfig gitAutoConfig;

    @RequestMapping("/from")
    public String from(){
        return this.gitAutoConfig.getFrom();
    }
}
