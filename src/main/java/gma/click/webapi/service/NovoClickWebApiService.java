package gma.click.webapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gma.click.domain.service.INovoClickService;
import gma.click.domain.service.ServiceResult;
import gma.click.webapi.dto.ClickDto;

@Service
public class NovoClickWebApiService implements INovoClickWebApiService {
	
	private INovoClickService _novoClickService;
	
	private NovoClickWebApiService() {}
	
	@Autowired
	private NovoClickWebApiService(INovoClickService novoClickService){
		
		_novoClickService=novoClickService;
	}
	
	public static INovoClickWebApiService New(INovoClickService novoClickService) {
		return new NovoClickWebApiService(novoClickService);
	}

	//Observação estou usando os Ids como string obedecendo o modelo, mas o idel é long ou int
	
	
	@Override
	public ResponseEntity<?> novo(ClickDto clickDto) {
	 
		//validação inicial
		// no serviço que processa a validação pode ser feita a validação
		//existencia cliente, etc
		if(clickDto==null)
		{
			return new ResponseEntity<List<String>>( Arrays.asList(MSG_INFO_N_PODE_SER_NULL),  HttpStatus.BAD_REQUEST);
		}
		
		 
		
		//TODO colocar try capturar erro quando colocar repositorio mongo e transacao
		 ServiceResult rs=_novoClickService.novo(clickDto.getAd_id(), clickDto.getAccount_id(), clickDto.getCpc());
		
		 if(rs.existeErro()) return new ResponseEntity<>( rs.getListaMsg(),  HttpStatus.BAD_REQUEST);
		 
		 
		 
		 
		 
		return    new ResponseEntity<>(  HttpStatus.NO_CONTENT);
	}

	
	
}
