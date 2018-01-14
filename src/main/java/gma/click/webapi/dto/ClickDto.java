package gma.click.webapi.dto;

public class ClickDto {

	private String ad_id;
	private String account_id;
	private float cpc;
	
    public ClickDto() {}
    public ClickDto(String ad_id,String account_id,float cpc){
    	
    	this.ad_id=ad_id;
    	this.account_id=account_id;
    	this.cpc=cpc;
    	
    }
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public float getCpc() {
		return cpc;
	}
	public void setCpc(float cpc) {
		this.cpc = cpc;
	}
	
}
