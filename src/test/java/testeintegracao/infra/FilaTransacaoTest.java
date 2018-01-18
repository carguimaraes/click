package testeintegracao.infra;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gma.click.config.Principal;
import gma.click.domain.service.ISendTransacao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Principal.class)
public class FilaTransacaoTest {
	
	@Autowired
	private ISendTransacao _sendTransacao;
	
	@Ignore(value="usado para teste manual - comentar o ignore para executar o teste")
	@Test
	public void send()
	{
		
	}

}
