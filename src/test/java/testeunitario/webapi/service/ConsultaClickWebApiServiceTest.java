package testeunitario.webapi.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import gma.click.domain.entity.Click;
import gma.click.domain.respository.IClickRepository;
import gma.click.webapi.dto.ClickDto;
import gma.click.webapi.service.ConsultaClickWebApiService;
import gma.click.webapi.service.IConsultaClickWebApiService;
import gma.click.webapi.service.INovoClickWebApiService;
import gma.click.webapi.service.NovoClickWebApiService;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaClickWebApiServiceTest {

	private IConsultaClickWebApiService _consultaClickWebApiService;

	@Mock 
	private IClickRepository _clickRepositoryMock;

	@Before
	public void setup() {

		_consultaClickWebApiService = ConsultaClickWebApiService.New(_clickRepositoryMock);
	}

	@Test
	public void buscarPorAdId_falhaParametroNaoInformado_retornaMsgErro() {

		ResponseEntity<List<String>> ret = (ResponseEntity<List<String>>) _consultaClickWebApiService.buscarPorAdId(null);

		assertEquals(HttpStatus.BAD_REQUEST, ret.getStatusCode());

		assertEquals(IConsultaClickWebApiService.MSG_PRM_BUSCA_N_INFORMADO, ret.getBody().get(0));
	}
	
	@Test
	public void buscarPorAdId_falhaInformacaoNaoEncontrada_retornaMsgErro() {
		Click ck= new Click();
		
		Mockito.
		when(_clickRepositoryMock.findByAdId( Mockito.anyString() )).thenReturn(null);
		

		ResponseEntity<List<String>> ret = (ResponseEntity<List<String>>) _consultaClickWebApiService.buscarPorAdId("1");

		assertEquals(HttpStatus.NOT_FOUND, ret.getStatusCode());

		assertEquals(IConsultaClickWebApiService.MSG_INFO_N_ENCONTRADA, ret.getBody().get(0));
		
		
	}
	
	@Test
	public void buscarPorAdId_sucesso_retornaClickDto() {
		Click ck= new Click();
		ck.setAd_id("1967");
		
		Mockito.
		when(_clickRepositoryMock.findByAdId( Mockito.anyString() )).thenReturn(ck);
		

		ResponseEntity<ClickDto> ret = (ResponseEntity<ClickDto>) _consultaClickWebApiService.buscarPorAdId("1");

		assertEquals(HttpStatus.OK, ret.getStatusCode());

		assertEquals("1967", ret.getBody().getAd_id());
		
		
	}

}
