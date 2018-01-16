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
import gma.click.webapi.service.IConsultaClickWebApiService;
import gma.click.webapi.service.INovoClickWebApiService;

//http://192.168.1.113:8080/api/v1/clicks
//http://localhost:8080/api/v1/clicks

 
@RestController
@RequestMapping("api/v1")
public class ClickController {
	 
	@Autowired
	private IConsultaClickWebApiService _consultaClickWebApiService;
	 
	@Autowired
	private INovoClickWebApiService _novoClickWebApiService; 
	
	
	//Content-Type: application/json; charset=UTF-8
	@RequestMapping(method=RequestMethod.POST,path="/clicks")
	public ResponseEntity<?> novoClick(@RequestBody ClickDto clickDto)
	{
	 	
		return   _novoClickWebApiService.novo(clickDto);
	}
	
	//TODO id = String - seguindo documentação da prova de conceito - ideal e ser long ou int
	@RequestMapping(method=RequestMethod.GET,path="/clicks/{adId}",produces = "application/json")
	public ResponseEntity<?> getClick(@PathVariable("adId") String adId)
	{
	 
	 	
		return   _consultaClickWebApiService.buscarPorAdId(adId);
	}
	

}
