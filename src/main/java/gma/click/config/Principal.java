package gma.click.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.DispatcherServlet;

//TODO package gma.click.domain.respository - RETIRAR DO SCAN... QUANDO REPOSITORIOS T IMP
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "gma.click.domain.repository")
@EntityScan("gma.click.domain.entity")
@ComponentScan({"gma.click.config",
	            "gma.click.infra", 
	            "gma.click.domain.repository",
	 			"gma.click.domain.service",
	            "gma.click.webapi.controller",
	            "gma.click.webapi.service"
	            
	            })

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("APLICACAO INICIALIZADA");
		//SpringApplication.run(Principal.class,args);
		
		ApplicationContext apCtx= SpringApplication.run(Principal.class,args);
		
		
		//ConfigurableApplicationContext c= (ConfigurableApplicationContext) apCtx;
		
		//c.registerShutdownHook();
		
		 System.out.println("APLICACAO FINALIZADA");
		 
	}

}
