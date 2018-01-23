package gma.click.infra;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
import testeintegracao.infra.CustomMessage;

@Component
public class FilaTransacao implements ISendTransacao {
	
	
	@Autowired
	private Environment _env;
	
	@Autowired
	private RabbitTemplate _rabbitTemplate ;
	
	
	private FilaTransacao() {}
	
	private static ISendTransacao New() {
		return new FilaTransacao();
	}
	
	
	@Override
	public boolean executar(TransacaoMensagem msg) throws Exception{
		
	
		 //_rabbitTemplate.convertAndSend(new CustomMessage(2017001, "VALOR TESTE 02"));
		 
		 _rabbitTemplate.convertAndSend("VALOR TESTE 02");
		 
		
		return true;
	}
	
	

	//@Override
	public boolean ___executar(TransacaoMensagem msg) throws Exception {
		
		
		//TODO colocar teste para verificar propriedades iniciadas com valor
		String filaNome = _env.getProperty("fila.nome");
		String  filaUsername=_env.getProperty("fila.username");
		String filaSenha=_env.getProperty("fila.senha");
		String filaHost=_env.getProperty("fila.host");

		ConnectionFactory factory = new ConnectionFactory();

		factory.setUsername(filaUsername);
		factory.setPassword(filaSenha);
		factory.setHost(filaHost);
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(filaNome, false, false, false, null);
		String message = msg.toString();
		channel.basicPublish("", filaNome, null, message.getBytes());

		channel.close();
		connection.close();
		return false;
	}

}
