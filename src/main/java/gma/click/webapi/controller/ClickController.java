package gma.click.webapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;

import gma.click.webapi.dto.ClickDto;

//http://192.168.1.113:8080/api/v1/clicks
//http://localhost:8080/api/v1/clicks

 
@RestController
@RequestMapping("api/v1")
public class ClickController {
	
	//@Autowired
	//private IArquivoRepository _arquivoRepository;
	 
	
	@RequestMapping(method=RequestMethod.GET,path="/clicks",produces = "application/json")
	public ResponseEntity<?> getListClick()
	{
		
		List<ClickDto> listClick= new ArrayList<>();
		
	
		for(int i=1;i<=10;i++)
		{
			listClick.add(new ClickDto("2"+i,"3"+i,0.2F));	
		}
		
		return   new ResponseEntity<List<ClickDto>>( listClick, HttpStatus.OK);
	}
	
	//Content-Type: application/json; charset=UTF-8
	@RequestMapping(method=RequestMethod.POST,path="/clicks")
	public ResponseEntity<?> newClick(@RequestBody ClickDto clickDto)
	{
	 	
		return   new ResponseEntity<List<ClickDto>>(  HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/clicks/{id}",produces = "application/json")
	public ResponseEntity<?> getClick(@PathVariable("id") long id)
	{
	 	
		return   new ResponseEntity<ClickDto>(new ClickDto("21","3",0.2F),  HttpStatus.OK);
	}
	

}
