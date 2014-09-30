package com.hp.devops.receive;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.RabbitResourceHolder;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: belozovs
 * Date: 9/30/14
 * Description
 */
@Component
public class TypeOneListener {


    public void handleMessage(Object obj){
        String str = (String) obj;
        System.out.println("One info received: "+str);

    }


}
