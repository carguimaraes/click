package testeunitario.webapi.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import gma.click.domain.service.INovoClickService;
import gma.click.domain.service.ServiceResult;
import gma.click.webapi.dto.ClickDto;
import gma.click.webapi.service.INovoClickWebApiService;
import gma.click.webapi.service.NovoClickWebApiService;
import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class NovoClickWebApiServiceTest {
	
	private INovoClickWebApiService _novoClickWebApiService;
	
	@Mock
	private INovoClickService _novoClickServiceMock;
	
	@Before
    public void setup() {
     
		_novoClickWebApiService= NovoClickWebApiService.New(_novoClickServiceMock);
    }

	@Test
	public void novo_falha_parametroNull_retornaMensagemErro()
	{
		ResponseEntity<List<String>> ret=	(ResponseEntity<List<String>>) _novoClickWebApiService.novo(null);
		
		assertEquals( HttpStatus.BAD_REQUEST,  ret.getStatusCode());
		
	    assertEquals( INovoClickWebApiService.MSG_INFO_N_PODE_SER_NULL,  ret.getBody().get(0));
		
	}
	
	@Test
	public void novo_falha_parametroInvalido_retornaMensagemErro() throws Exception
	{
		ClickDto clickDto= new ClickDto("","",0F);
		ServiceResult rs= new ServiceResult();
		rs.add("1111");
		rs.add("2222");
		rs.add("3333");
		
		Mockito.
		when(_novoClickServiceMock.novo(Mockito.anyString(),Mockito.anyString(),Mockito.anyFloat()))
		.thenReturn(rs);
		
		ResponseEntity<List<String>> ret=	(ResponseEntity<List<String>>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.BAD_REQUEST,  ret.getStatusCode());
		
	    assertEquals( "1111",  ret.getBody().get(0));
	    assertEquals( "2222",  ret.getBody().get(1));
	    assertEquals( "3333",  ret.getBody().get(2));
		
	
	    
	}
	 
	@Test
	public void novo_falhaErroInternoProcessamentoFila_retornaMsgErro() throws Exception
	{
		ClickDto clickDto= new ClickDto("1","1",10F);
		ServiceResult rs= new ServiceResult();
		
		Mockito.
			when(_novoClickServiceMock.novo(Mockito.anyString(),Mockito.anyString(),Mockito.anyFloat()))
			.thenThrow(new Exception("ERRRO SERVIÇO"));
		 
		ResponseEntity<List<String>> ret=	(ResponseEntity<List<String>>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.INTERNAL_SERVER_ERROR,  ret.getStatusCode());
			 
		 assertEquals( INovoClickWebApiService.MSG_ERRO_INTERNO_GERAR_TRANS,  ret.getBody().get(0));
		
	}
	
	
	@Test
	public void novo_sucesso_retornaOk() throws Exception
	{
		ClickDto clickDto= new ClickDto("1","1",10F);
		ServiceResult rs= new ServiceResult();
		
		Mockito.
			when(_novoClickServiceMock.novo(Mockito.anyString(),Mockito.anyString(),Mockito.anyFloat()))
			.thenReturn(rs);
		 
		ResponseEntity<?> ret=	(ResponseEntity<?>) _novoClickWebApiService.novo(clickDto);
		
		assertEquals( HttpStatus.NO_CONTENT,  ret.getStatusCode());
		
	    assertEquals( null,  ret.getBody());
		
	}
	
}
