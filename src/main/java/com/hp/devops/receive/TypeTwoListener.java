package com.hp.devops.receive;

import org.springframework.stereotype.Component;

/**
 * User: belozovs
 * Date: 9/30/14
 * Description
 */
@Component
public class TypeTwoListener {

    public void handleMessage(Object obj){
        String str = (String) obj;
        System.out.println("Two info received: "+str);
    }


}
