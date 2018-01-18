package testeintegracao.domain.repository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import gma.click.config.Principal;
import gma.click.domain.entity.Click;
import gma.click.domain.repository.IClickRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Principal.class)
public class ClickRepositoryTest {
	
	
	@Autowired
	private IClickRepository  _clickRepository;
	
	@Ignore(value="usado para teste manual - comentar o ignore para executar o teste")
	@Test
	public void sava_inclusao()
	{
		Click ck= new Click();
		ck.setAd_id("1967");
		ck.setAccount_id("123");
		ck.setCpc(0.8F);
		
		_clickRepository.save(ck);		
		
	}
	
	@Ignore(value="usado para teste manual - comentar o ignore para executar o teste")
	@Test
	public void findByAdId()
	{
		Click ck;
		
		System.out.println("Buscando...");
			
		ck=_clickRepository.findByAdId("19676");
		
		
	
		if(ck!=null)
		{
			System.out.println("Enconrado: "+ck.getCpc());
		}
		else
		{
			System.out.println("nao encontrado");
		}
		
		System.out.println("fim");
	}

}
