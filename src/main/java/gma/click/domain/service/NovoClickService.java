package gma.click.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NovoClickService implements INovoClickService {

 
	private NovoClickService() {}
	
	public static INovoClickService New()
	{
		return new  NovoClickService();
	}
	
	
	@Override
	public ServiceResult novo(String ad_id, String account_id, float cpc) {
		
		ServiceResult serviceResult= new ServiceResult();
		 
		if(ad_id==null || ad_id.trim().isEmpty())
		{
			serviceResult.add(MSG_AD_ID_N_INFORMADO);
		
		}
		if( account_id ==null || account_id.trim().isEmpty())
		{
			serviceResult.add(MSG_ACCOUNT_ID_N_INFORMADO);
		
		}
		if( (cpc<=0) || cpc>100)
		{
			serviceResult.add(MSG_CPC_INVALIDO);
		}
		
		return serviceResult;
	}

}
