package gma.click.webapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gma.click.webapi.dto.ClickDto;

@Service
public class NovoClickWebApiService implements INovoClickWebApiService {
	

	public static String MSG_INFO_N_PODE_SER_NULL="Informação do click não pode ser nula";
	public static String MSG_AD_ID_N_INFORMADO= "Ad_id não informado";
	public static String MSG_ACCOUNT_ID_N_INFORMADO= "Account_id não informado";
	public static String MSG_CPC_INVALIDO= "Cpc invalido";
	
	
	private NovoClickWebApiService() {}
	
	public static INovoClickWebApiService New() {
		return new NovoClickWebApiService();
	}

	@Override
	public ResponseEntity<?> novo(ClickDto clickDto) {
	 
		//validação inicial
		// no serviço que processa a validação pode ser feita a validação
		//existencia cliente, etc
		if(clickDto==null)
		{
		 	
			return new ResponseEntity<String>(MSG_INFO_N_PODE_SER_NULL,  HttpStatus.BAD_REQUEST);
		}
		if(clickDto.getAd_id()==null || clickDto.getAd_id().isEmpty())
		{
			return new ResponseEntity<String>(MSG_AD_ID_N_INFORMADO,  HttpStatus.BAD_REQUEST);
		}
		if(clickDto.getAccount_id() ==null || clickDto.getAccount_id().isEmpty())
		{
			return new ResponseEntity<String>(MSG_ACCOUNT_ID_N_INFORMADO,  HttpStatus.BAD_REQUEST);
		}
		if( (clickDto.getCpc()<=0) || clickDto.getCpc()>100)
		{
			return new ResponseEntity<String>(MSG_CPC_INVALIDO,  HttpStatus.BAD_REQUEST);
		}
		
		
		return    new ResponseEntity<>(  HttpStatus.NO_CONTENT);
	}

	
	
}
