package testeunitario.webapi.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import gma.click.webapi.dto.ClickDto;
import gma.click.webapi.service.INovoClickWebApiService;
import gma.click.webapi.service.NovoClickWebApiService;
import junit.framework.Assert;

//@RunWith(MockitoJUnitRunner.class)
public class NovoClickWebApiServiceTest {
	
	private INovoClickWebApiService _novoClickWebApiService;
	
	
	@Before
    public void setup() {
     
		_novoClickWebApiService= NovoClickWebApiService.New();
    }

	@Test
	public void novo_falha_parametroNull_retornaMensagemErro()
	{
		ResponseEntity<String> ret=	(ResponseEntity<String>) _novoClickWebApiService.novo(null);
		
		assertEquals( HttpStatus.BAD_REQUEST,  ret.getStatusCode());
		
	    assertEquals( NovoClickWebApiService.MSG_INFO_N_PODE_SER_NULL,  ret.getBody());
		
	}
	
	@Test
	public void novo_falha_ad_idNaoInformado_retornaMensagemErro()
	{
	
		ClickDto clickDto= new ClickDto(null,"1",0.2F);
		 
		ResponseEntity<String> ret=	(ResponseEntity<String>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.BAD_REQUEST,  ret.getStatusCode());
		
	    assertEquals( NovoClickWebApiService.MSG_AD_ID_N_INFORMADO,  ret.getBody());
		
	}
	//TODO Pode se usar um teste parametizado para o caso de Empty e Null
	@Test
	public void novo_falha_Account_idNaoInformado_retornaMensagemErro()
	{
		ClickDto clickDto= new ClickDto("1","",0.2F);
		
		 
		ResponseEntity<String> ret=	(ResponseEntity<String>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.BAD_REQUEST,  ret.getStatusCode());
		
	    assertEquals( NovoClickWebApiService.MSG_ACCOUNT_ID_N_INFORMADO,  ret.getBody());
		
	}
	
	//TODO Pode ser feito um tete parametrizado para verificar 0 e > 100
	//Mas nao vou chegar a este nivel - o objetivo e mostrar o teste
	@Test
	public void novo_falha_CpcNaoInformado_retornaMensagemErro()
	{
		ClickDto clickDto= new ClickDto("1","1",0F);
		
		 
		ResponseEntity<String> ret=	(ResponseEntity<String>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.BAD_REQUEST,  ret.getStatusCode());
		
	    assertEquals( NovoClickWebApiService.MSG_CPC_INVALIDO,  ret.getBody());
		
	}
	
	@Test
	public void novo_sucesso_retornaOk()
	{
		ClickDto clickDto= new ClickDto("1","1",10F);
		
		 
		ResponseEntity<String> ret=	(ResponseEntity<String>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.NO_CONTENT,  ret.getStatusCode());
		
	    assertEquals( null,  ret.getBody());
		
	}
	
}
