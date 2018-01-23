package testeintegracao.infra;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import gma.click.config.Principal;

//O objjtivo deste teste e verificar os valores do arquivo de propriedades

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Principal.class)
public class ApplicationPropertiesTest {
	
	@Autowired
	private Environment _env;

	@Ignore(value="usado para teste manual - comentar o ignore para executar o teste")
	@Test
	public void mongodbValores()
	{
		System.out.println("spring.data.mongodb.host --> "+_env.getProperty("spring.data.mongodb.host"));
		System.out.println("spring.data.mongodb.port --> "+_env.getProperty("spring.data.mongodb.port"));
		System.out.println("spring.data.mongodb.database --> "+_env.getProperty("spring.data.mongodb.database"));
		
	}

	@Ignore(value="usado para teste manual - comentar o ignore para executar o teste")
	@Test
	public void filaValores()
	{
 		
		System.out.println("file.nome --> "+_env.getProperty("fila.nome"));
		System.out.println("fila.username --> "+_env.getProperty("fila.username"));
		System.out.println("fila.senha --> "+_env.getProperty("fila.senha"));
		System.out.println("fila.host --> "+_env.getProperty("fila.host"));
		
	}
	
}
