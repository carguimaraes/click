package gma.click.infra;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsomeFila implements MessageListener {

	@Autowired
	private MessageConverter _messageConverter;
	
	
//	public ConsomeFila(MessageConverter messageConverter) {
//		_messageConverter=messageConverter;
//	}

	@Override
	public void onMessage(Message message) {

		

		CustomMessage x = (CustomMessage) _messageConverter.fromMessage(message);

		System.out.println("===RECEBENDO MENSAGEM=======================");
		System.out.println(new String(message.getBody()));

		System.out.println("====>" + x.getName());
		System.out.println("==========================================");
	}

}
