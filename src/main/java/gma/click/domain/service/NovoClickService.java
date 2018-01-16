package gma.click.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NovoClickService implements INovoClickService {

 
	private ISendTransacao _sendTransacao;
	
	private NovoClickService() {}
	
	@Autowired
	private NovoClickService(ISendTransacao sendTransacao) {
		
		_sendTransacao=sendTransacao;
	}
	
	public static INovoClickService New(ISendTransacao sendTransacao)
	{
		return new  NovoClickService(sendTransacao);
	}
	
	
	@Override
	public ServiceResult novo(String ad_id, String account_id, float cpc) throws Exception {
		
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
		
		
		if(serviceResult.existeErro()) return serviceResult;
		//TODO nao sera validado se id existe
		
		//manda para a fila
		_sendTransacao.executar("Teste GMA mensagem");
		
		return serviceResult;
	}

}
