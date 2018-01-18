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
	
	private FilaTransacao() {}
	
	private static ISendTransacao New() {
		return new FilaTransacao();
	}
	

	@Override
	public boolean executar(TransacaoMensagem msg) throws Exception {
		
		
		String fileNome = "filaClick";
		String  filaUsername="admin";
		String filaSenha="123";
		String filaHost="192.168.1.113";

		ConnectionFactory factory = new ConnectionFactory();

		factory.setUsername(filaUsername);
		factory.setPassword(filaSenha);
		// factory.setVirtualHost(virtualHost);

		factory.setHost(filaHost);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(fileNome, false, false, false, null);
		String message = "Ola Vida Boa";
		channel.basicPublish("", fileNome, null, message.getBytes());

		channel.close();
		connection.close();
		return false;
	}

}
