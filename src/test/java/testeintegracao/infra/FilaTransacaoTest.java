package testeintegracao.infra;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gma.click.config.Principal;
import gma.click.domain.service.ISendTransacao;
import gma.click.domain.service.TransacaoMensagem;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Principal.class)
public class FilaTransacaoTest {
	
	@Autowired
	private ISendTransacao _sendTransacao;
	
	@Ignore(value="usado para teste manual - comentar o ignore para executar o teste")
	@Test
	public void send()  
	{
		TransacaoMensagem tm= new TransacaoMensagem();
		
		tm.msg="GMA TESTE 222222 - 19:40h";
		
		try {
			System.out.println("Inicio envio msg");
			_sendTransacao.executar(tm);
			System.out.println("fim");
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
	}

}
