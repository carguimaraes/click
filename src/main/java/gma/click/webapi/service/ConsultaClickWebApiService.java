package gma.click.webapi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gma.click.domain.respository.IClickRepository;
import gma.click.domain.service.INovoClickService;
import gma.click.webapi.dto.ClickDto;


@Service
public class ConsultaClickWebApiService implements IConsultaClickWebApiService {

	
	private  IClickRepository  _clickRepository;
	
	private ConsultaClickWebApiService() {}
	
	@Autowired
	private ConsultaClickWebApiService(IClickRepository  clickRepository) {
		
		_clickRepository=clickRepository;
	}
	
	public static IConsultaClickWebApiService  New(IClickRepository  clickRepository) {
		return new ConsultaClickWebApiService (clickRepository);
	}

	@Override
	public ResponseEntity<?> buscarPorAdId(String adId) {


		if(adId==null || adId.trim().isEmpty())
		{
			return new ResponseEntity<List<String>>( Arrays.asList(MSG_PRM_BUSCA_N_INFORMADO),  HttpStatus.BAD_REQUEST);
		}
		
		
		ClickDto dto= new ClickDto("1","22",10F);
		
		return  new ResponseEntity<ClickDto>(dto,  HttpStatus.OK);
	}
	
	
	 
	
}
