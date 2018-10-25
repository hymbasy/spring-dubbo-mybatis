package com.alex.listener;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class MsgReceiverListener implements MessageListener {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void onMessage(Message message) {
        try {
            //将字节流对象转换成Java对象
            Object o = (Object) new ObjectInputStream(new ByteArrayInputStream(message.getBody())).readObject();
            System.out.println("年龄：" + JSON.toJSONString(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String replyTo = message.getMessageProperties().getReplyTo();
        MessageConverter messageConverter = new SimpleMessageConverter();

        MessageProperties messageProperties = new MessageProperties();
        messageProperties.getHeaders().putAll(message.getMessageProperties().getHeaders());

        String response = new String("收到返回消息");
        //将Java对象转成Message对象，并作为返回的内容，回送给生产者
        Message message2 = messageConverter.toMessage(response, messageProperties);
        amqpTemplate.send(replyTo, message2);
    }
}
