package gma.click.webapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gma.click.domain.service.INovoClickService;
import gma.click.webapi.dto.ClickDto;

@Service
public class NovoClickWebApiService implements INovoClickWebApiService {
	

	public static String MSG_INFO_N_PODE_SER_NULL="Informação do click não pode ser nula";
	 
	
	
	private INovoClickService _novoClickService;
	
	private NovoClickWebApiService() {}
	
	public static INovoClickWebApiService New() {
		return new NovoClickWebApiService();
	}

	//Observação estou usando os Ids como string obedecendo o modelo, mas o idel é long ou int
	
	
	@Override
	public ResponseEntity<?> novo(ClickDto clickDto) {
	 
		//validação inicial
		// no serviço que processa a validação pode ser feita a validação
		//existencia cliente, etc
		if(clickDto==null)
		{
		 	
			return new ResponseEntity<String>(MSG_INFO_N_PODE_SER_NULL,  HttpStatus.BAD_REQUEST);
		}
		 
		
		
		
		
		return    new ResponseEntity<>(  HttpStatus.NO_CONTENT);
	}

	
	
}
