package gma.click.webapi.service;

import org.springframework.http.ResponseEntity;

import gma.click.webapi.dto.ClickDto;

public interface INovoClickWebApiService {
	
	public static String MSG_INFO_N_PODE_SER_NULL="Informação do click não pode ser nula"; 
	public static String MSG_ERRO_INTERNO_GERAR_TRANS="Erro interno ao tentar gerar trnsação";
	
	
	public ResponseEntity<?> novo(ClickDto clickDto);

}
