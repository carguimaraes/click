package gma.click.webapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping(path="/*" , value= {"/*", "/api/*"})
	public ResponseEntity<?> naoEncontrado()
	{
		return     new ResponseEntity<List<String>>( Arrays.asList("Recurso não encontrado"),  HttpStatus.NOT_FOUND);
	}
	
	/*
	@RequestMapping(path="/api/*")
	public ResponseEntity<?> naoEncontrado2()
	{
		return     new ResponseEntity<List<String>>( Arrays.asList("Recurso não encontrado"),  HttpStatus.NOT_FOUND);
	}
*/

}
