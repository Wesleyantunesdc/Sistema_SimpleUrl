package com.developer.api.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.api.entidades.Link;

@RestController
@RequestMapping(value = "/links")
public class LinkRecurso {
	
	@GetMapping
	public ResponseEntity<Link> listarTodos(){
		Link link = new Link("www.teste./dasdsa/dasasdas", "endereco.com");
		return ResponseEntity.ok().body(link);
	}
}
