package gma.click.infra;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import gma.click.domain.service.ISendTransacao;
import gma.click.domain.service.TransacaoMensagem;

@Component
public class FilaTransacao implements ISendTransacao {

	@Override
	public boolean executar(TransacaoMensagem msg) throws Exception {
		String QUEUE_NAME = "filaClick";

		ConnectionFactory factory = new ConnectionFactory();

		factory.setUsername("admin");
		factory.setPassword("123");
		// factory.setVirtualHost(virtualHost);

		factory.setHost("192.168.1.113");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "Ola Vida Boa";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

		channel.close();
		connection.close();
		return false;
	}

}
