package hu.infokristaly.messagingconsumer.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import hu.infokristaly.messagingconsumer.jms.dtos.Customer;

@Component
public class MyBean {
    
    @JmsListener(destination = "someQueue", containerFactory = "myFactory")
	public void processMessage(Customer content) {
		System.out.println("Received message: " + content);
	}
}
