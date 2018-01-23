package gma.click.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import gma.click.infra.ConsomeFila;

@Configuration
public class RabbitMqConfig {

	
	@Autowired
	private Environment _env;
	
	@Autowired
	private MessageListener _messageListener;
	
	

	@Bean
	public ConnectionFactory connectionFactory() {
		
	
		String  filaUsername=_env.getProperty("fila.username");
		String filaSenha=_env.getProperty("fila.senha");
		String filaHost=_env.getProperty("fila.host");
		
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(filaHost);
		connectionFactory.setUsername(filaUsername);
		connectionFactory.setPassword(filaSenha);
		
		
		return connectionFactory;
	}

	@Bean
	public Queue simpleQueue() {
		String fileNome = _env.getProperty("fila.nome");
		return new Queue(fileNome);
	}

	
	//TODO PARA USO FUTURO
	@Bean
	public MessageConverter jsonMessageConverter() {
		return  new   Jackson2JsonMessageConverter(); // new JsonMessageConverter();
	}

	
	@Bean
	public RabbitTemplate rabbitTemplate() {
		String filaNome = _env.getProperty("fila.nome");
		
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(filaNome);
		
		 
		//TODO PARA USO FUTURO
		template.setMessageConverter(jsonMessageConverter());
		return template;
	}



	
	@Bean
	public SimpleMessageListenerContainer listenerContainer() {
		SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
		listenerContainer.setConnectionFactory(connectionFactory());
		listenerContainer.setQueues(simpleQueue());
		//TODO PARA USO FUTURO
		listenerContainer.setMessageConverter(jsonMessageConverter());
		listenerContainer.setMessageListener(_messageListener); //   new ConsomeFila(jsonMessageConverter()));
		listenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
		return listenerContainer;
	}

}
