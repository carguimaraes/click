package gma.click.domain.respository;

import org.springframework.stereotype.Repository;

import gma.click.domain.entity.Click;
import gma.click.webapi.dto.ClickDto;

@Repository
public class ClickRepositoryImp implements IClickRepository {

	@Override
	public Click findByAdId(String adId) {
		
		Click ck= new Click();
		
		ck.setAccount_id("2221");
		ck.setAd_id("1967");
		ck.setCpc(0.8F);
		
 		return ck;
	}

	 
	
	

}
