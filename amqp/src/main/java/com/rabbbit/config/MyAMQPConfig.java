package com.rabbbit.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : gelianbin
 * @createDate : 2021/3/10
 */

@Configuration
public class MyAMQPConfig {

    @Bean
    //点进去MessageConverter，，点击Ctrl + H 可以查看有哪些Converter
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
