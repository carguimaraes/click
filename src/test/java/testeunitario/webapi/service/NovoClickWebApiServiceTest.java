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
	public void novo_sucesso_retornaOk()
	{
		ClickDto clickDto= new ClickDto("1","1",10F);
		
		 
		ResponseEntity<String> ret=	(ResponseEntity<String>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.NO_CONTENT,  ret.getStatusCode());
		
	    assertEquals( null,  ret.getBody());
		
	}
	
}
