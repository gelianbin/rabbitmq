package com.rabbbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
rabbitmq自动配置
1.自动配置类：RabbitAutoConfiguration
2.有自动配置类连接工厂ConnectionFactory
3.RabbitProperties封装了Rabbbitmq的配置
 4.RabbitTemplate:给RabbitMQ发送和接受消息的
 5.AmqpAdmin: Rabbitmq系统管理功能组件
    AmqpAdmin 创建和删除 Queue ,Exchange ,Binding

 6.@EnableRabbit  +  @RabbitListener 监听消息队列里的内容
 */
@EnableRabbit //开启基于注解的RabbitMQ模式
@SpringBootApplication
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }

}
