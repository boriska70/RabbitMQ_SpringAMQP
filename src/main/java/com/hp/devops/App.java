package com.hp.devops;

import com.hp.devops.send.Sender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: belozovs
 * Date: 9/30/14
 * Description
 */
public class App {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/myappContext.xml");

        Sender sender = (Sender) context.getBean("sender");

        System.out.println("Start sending");

        sender.sendMessage();
        System.out.println("Done");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        System.exit(0);
    }

}
