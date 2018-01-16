package testeunitario.domain.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import gma.click.domain.service.INovoClickService;
import gma.click.domain.service.ISendTransacao;
import gma.click.domain.service.NovoClickService;
import gma.click.domain.service.ServiceResult;
import gma.click.webapi.service.NovoClickWebApiService;

@RunWith(MockitoJUnitRunner.class)
public class NovoClickServiceTest {

	
	private INovoClickService _novoClickService;
	
	@Mock
	private  ISendTransacao _sendTransacaoMock;
	
	@Before
    public void setup() {
     
		_novoClickService= NovoClickService.New(_sendTransacaoMock);
    }
	
	@Test
	public void novo_falha_parametroInvalido_retornaMensagemErro() throws Exception
	{
		ServiceResult serviceResult=	_novoClickService.novo("", null, 0F);
		
		assertTrue( serviceResult.existeErro());
		assertTrue( serviceResult.contemMsg(INovoClickService.MSG_AD_ID_N_INFORMADO));
		assertTrue( serviceResult.contemMsg(INovoClickService.MSG_ACCOUNT_ID_N_INFORMADO));
		assertTrue( serviceResult.contemMsg(INovoClickService.MSG_CPC_INVALIDO));
		 
	}
	
	@Test
	public void novo_sucesso_criaEntradaTransacaoFila() throws Exception
	{
		
		Mockito.
		when(_sendTransacaoMock.executar( Mockito.anyString() )).thenReturn(true);
		
		ServiceResult serviceResult=	_novoClickService.novo("1967","123", 0.10F);
		
		 
		assertTrue( !serviceResult.existeErro());	
		
		Mockito.verify(_sendTransacaoMock).executar(Mockito.anyString());
		 
	}
	
}

