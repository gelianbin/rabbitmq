package com.rabbbit.service;

import com.rabbbit.domin.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author : gelianbin
 * @createDate : 2021/3/10
 *
 * 订单-----》队列--------》库存
 * 现在需要一个监听队列
 */


@Service
public class BookService {

    //监听消息队列的（可以多个）
    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息"+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
