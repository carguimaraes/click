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

import gma.click.domain.entity.Click;
import gma.click.domain.respository.IClickRepository;
import gma.click.webapi.dto.ClickDto;
import gma.click.webapi.service.INovoClickWebApiService;

//http://192.168.1.113:8080/api/v1/clicks
//http://localhost:8080/api/v1/clicks

 
@RestController
@RequestMapping("api/v1")
public class ClickController {
	 
	
	@Autowired
	private  IClickRepository  _clickRepository;
	 
	@Autowired
	private INovoClickWebApiService _novoClickWebApiService; 
	
	
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
	public ResponseEntity<?> novoClick(@RequestBody ClickDto clickDto)
	{
	 	
		return   _novoClickWebApiService.novo(clickDto);
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/clicks/{id}",produces = "application/json")
	public ResponseEntity<?> getClick(@PathVariable("id") long id)
	{
	 
	 Click ck=	  _clickRepository.getById("1967");
	 ClickDto dto= new ClickDto(ck.getAd_id(),ck.getAccount_id(),ck.getCpc());	
		
		return   new ResponseEntity<ClickDto>(dto	,  HttpStatus.OK);
	}
	

}
