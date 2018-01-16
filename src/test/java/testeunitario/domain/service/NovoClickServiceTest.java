package testeunitario.domain.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import gma.click.domain.service.INovoClickService;
import gma.click.domain.service.NovoClickService;
import gma.click.domain.service.ServiceResult;
import gma.click.webapi.service.NovoClickWebApiService;

//@RunWith(MockitoJUnitRunner.class)
public class NovoClickServiceTest {

	
	private INovoClickService _novoClickService;
	
	@Before
    public void setup() {
     
		_novoClickService= NovoClickService.New();
    }
	
	@Test
	public void novo_falha_parametroInvalido_retornaMensagemErro()
	{
		ServiceResult serviceResult=	_novoClickService.novo("", null, 0F);
		
		assertTrue( serviceResult.existeErro());
		assertTrue( serviceResult.contemMsg(NovoClickService.MSG_AD_ID_N_INFORMADO));
		assertTrue( serviceResult.contemMsg(NovoClickService.MSG_ACCOUNT_ID_N_INFORMADO));
		assertTrue( serviceResult.contemMsg(NovoClickService.MSG_CPC_INVALIDO));
		 
	}
}
