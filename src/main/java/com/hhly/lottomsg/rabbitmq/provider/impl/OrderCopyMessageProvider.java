package com.hhly.lottomsg.rabbitmq.provider.impl;

import com.alibaba.fastjson.JSON;
import com.hhly.lottomsg.rabbitmq.provider.MessageProvider;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 发送消息
 *
 * @author yuanshangbing
 * @create 2017/5/22 17:08
 */
@Service("orderCopyMessageProvider")
public class OrderCopyMessageProvider implements MessageProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     *
     * @param queueKey 队列名
     * @param message  消息
     */
    @Override
    public void sendMessage(String queueKey, Object message) {
        String jsonStr = "";
        if (message instanceof String) {
            jsonStr = (String) message;
        } else {
            jsonStr = JSON.toJSONString(message);
        }
        byte[] body = jsonStr.getBytes();
        MessageProperties properties = new MessageProperties();
        properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        properties.setPriority(new Random().nextInt(10));
        Message message2 = new Message(body,properties );
        amqpTemplate.send(queueKey,message2);
    }
}