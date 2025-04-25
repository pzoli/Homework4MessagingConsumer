package hu.infokristaly.messagingconsumer.jms;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.boot.jms.ConnectionFactoryUnwrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;

@Configuration(proxyBeanMethods = false)
@EnableJms
public class MyJmsConfiguration {
    @Bean
	public DefaultJmsListenerContainerFactory myFactory(DefaultJmsListenerContainerFactoryConfigurer configurer,
			ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, ConnectionFactoryUnwrapper.unwrapCaching(connectionFactory));
		return factory;
	}
}
