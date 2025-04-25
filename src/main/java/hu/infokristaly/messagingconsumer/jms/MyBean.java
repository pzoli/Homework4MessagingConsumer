package hu.infokristaly.messagingconsumer.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Logger;

import hu.infokristaly.messagingconsumer.jms.dtos.Customer;

@Component
public class MyBean {
    
	@Autowired
	private ObjectMapper objectMapper;
	
	private static final Logger logger = Logger.getLogger("FileInfoController");

    @JmsListener(destination = "someQueue", containerFactory = "myFactory")
	public void processMessage(Customer content) {
		String jsonString;
		try {
			jsonString = objectMapper.writeValueAsString(content);
			logger.info("Received message: " + jsonString);
		} catch (JsonProcessingException e) {
			logger.severe("Error processing message: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
