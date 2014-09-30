package com.hp.devops.send;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.SimpleResourceHolder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: belozovs
 * Date: 9/22/14
 * Description
 */

@Component
public class Sender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    AtomicInteger index = new AtomicInteger();

    public void sendMessage() {
        Message message;
        for (int i = 0; i < 10; i++) {
            message = createMessage(">>> For one");
            rabbitTemplate.send("queue.one", message);
            message = createMessage(">>> For two");
            rabbitTemplate.send("queue.two", message);
            System.out.println("Message sent: " + message);
            index.getAndIncrement();
        }
    }

    private Message createMessage(String subject) {
        String msgString = subject + " message " + index.get();
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("myindex", index.get());
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN);
        Message message = new Message(msgString.getBytes(), messageProperties);
        return message;
    }

}
