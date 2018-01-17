package gma.click.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "click")
public class Click {

	@Id
	private String adId;
	private String accountId;
	private float cpc;

	public Click() {
	}

	public Click(String ad_id, String account_id, float cpc) {

		this.adId = ad_id;
		this.accountId = account_id;
		this.cpc = cpc;

	}

	public String getAdId() {
		return adId;
	}

	public void setAd_id(String ad_id) {
		this.adId = ad_id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccount_id(String account_id) {
		this.accountId = account_id;
	}

	public float getCpc() {
		return cpc;
	}

	public void setCpc(float cpc) {
		this.cpc = cpc;
	}

}
