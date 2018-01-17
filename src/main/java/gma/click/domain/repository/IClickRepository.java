package gma.click.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import gma.click.domain.entity.Click;

public interface IClickRepository   extends MongoRepository<Click, String> {
	
 public Click findByAdId(String adId);

}
