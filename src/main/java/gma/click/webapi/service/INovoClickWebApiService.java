package gma.click.webapi.service;

import org.springframework.http.ResponseEntity;

import gma.click.webapi.dto.ClickDto;

public interface INovoClickWebApiService {
	
	public static String MSG_INFO_N_PODE_SER_NULL="Informação do click não pode ser nula"; 
	
	public ResponseEntity<?> novo(ClickDto clickDto);

}
