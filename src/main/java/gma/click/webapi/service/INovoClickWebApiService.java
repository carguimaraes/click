package gma.click.webapi.service;

import org.springframework.http.ResponseEntity;

import gma.click.webapi.dto.ClickDto;

public interface INovoClickWebApiService {
	
	
	public ResponseEntity<?> novo(ClickDto clickDto);

}
