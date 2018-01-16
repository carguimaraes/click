package gma.click.webapi.service;

import org.springframework.http.ResponseEntity;

public interface IConsultaClickWebApiService {
	
    public static String MSG_PRM_BUSCA_N_INFORMADO="Parametro para busca nao informado";
    public static String MSG_INFO_N_ENCONTRADA="Informação não encontrada";
	
	public  ResponseEntity<?> buscarPorAdId(String adId);

}
