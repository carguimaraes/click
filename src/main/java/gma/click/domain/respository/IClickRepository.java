package gma.click.domain.respository;

import gma.click.domain.entity.Click;

public interface IClickRepository {
	
	public Click findByAdId(String adId);

}
