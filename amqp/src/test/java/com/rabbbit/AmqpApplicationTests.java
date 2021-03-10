package com.rabbbit;

import com.rabbbit.domin.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;


    @Test
    public void testAmqpAdmin(){
        //创建交换机
        amqpAdmin.declareExchange(new DirectExchange("exchange.admin"));
        //创建队列，持久化
        amqpAdmin.declareQueue(new Queue("queue.admin",true));

        //创建绑定规则（把交换机和队列绑定）
        amqpAdmin.declareBinding(
                new Binding("queue.admin",Binding.DestinationType.QUEUE,
                        "exchange.admin","amqp.hh",null));

    }

    /*
    1.单播（点对点）
     */
    @Test
    void contextLoads() {
        //message需要自己构造一个；定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routingKey,message);
        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routekey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一条消息");
        map.put("data", Arrays.asList("hello",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
//        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("君22莫笑","一叶知秋"));
    }

    //接受消息
    //如何将数据自动的转换为json 发送出去
    //因为RabbitTemplate 有默认的消息转换器MessageConverter messageConverter = new SimpleMessageConverter();
    //我们可以给他换一个MessageConverter
    @Test
    public void receive(){
        //获取队列atguigu.news的消息
        Object o = rabbitTemplate.receiveAndConvert("gulixueyuan.news");
        System.out.println(o.getClass());
        System.out.println(o);
        //class java.util.HashMap
        //{msg=这是第一条消息, data=[hello, 123, true]}
    }


    /*
    广播
     */
    @Test
    public void sendguan(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("1111","11111"));
    }

}
