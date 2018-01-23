package testeintegracao.infra;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ConsomeFila implements MessageListener{
	
	  @Override
	    public void onMessage(Message message) {
		  
		  System.out.println("===RECEBENDO MENSAGEM=======================");
	        System.out.println(new String(message.getBody()));
	        System.out.println("==========================================");  
	    }

}
