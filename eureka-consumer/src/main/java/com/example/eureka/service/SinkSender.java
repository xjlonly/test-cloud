package com.example.eureka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.nio.channels.Pipe;


@Component
@EnableBinding(Source.class)
public class SinkSender {
    private static Logger logger = LoggerFactory.getLogger(SinkSender.class);
//    @Autowired
//    SinkOutput sinkOutput;
//
//    public void sendSinkSenderTester(){
//        sinkOutput.output().send(MessageBuilder.withPayload("send message : http://192.168.0.53").build());
//    }

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedDelay = "2000000"))
    public MessageSource<String> timerMessageSoucre(){
        return ()->new GenericMessage<>("{\"name\":\"didi\", \"age\":23}");
    }
}
