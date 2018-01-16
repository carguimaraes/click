package gma.click.domain.service;

public interface INovoClickService {

	public static String MSG_AD_ID_N_INFORMADO= "Ad_id não informado";
	public static String MSG_ACCOUNT_ID_N_INFORMADO= "Account_id não informado";
	public static String MSG_CPC_INVALIDO= "Cpc invalido";
	
	
	public ServiceResult novo(String ad_id, String account_id, float cpc);
}
