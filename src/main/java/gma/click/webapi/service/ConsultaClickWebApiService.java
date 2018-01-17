package gma.click.webapi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import gma.click.domain.entity.Click;
import gma.click.domain.repository.IClickRepository;
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
		
		//TODO colocar captura de erro e gerar erro 500
		
		Click ck=_clickRepository.findByAdId(adId);
		
		if(ck==null) {
			return new ResponseEntity<List<String>>( Arrays.asList(MSG_INFO_N_ENCONTRADA),  HttpStatus.NOT_FOUND);
		}
		
		
		ClickDto dto= new ClickDto(ck.getAdId(),ck.getAccountId(),ck.getCpc());
		
		return  new ResponseEntity<ClickDto>(dto,  HttpStatus.OK);
	}
	
	
	 
	
}
