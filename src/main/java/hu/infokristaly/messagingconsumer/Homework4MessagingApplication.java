package hu.infokristaly.messagingconsumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import hu.infokristaly.messagingconsumer.jms.dtos.Customer;

@SpringBootApplication
public class Homework4MessagingApplication {

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		Map<String, Class<?>> typeIdMap = new HashMap<>();
        typeIdMap.put(Customer.class.getName(),Customer.class);
        converter.setTypeIdMappings(typeIdMap);
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	public static void main(String[] args) {
		SpringApplication.run(Homework4MessagingApplication.class, args);
	}

}
