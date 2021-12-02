package com.developer.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.developer.api.entidades.Link;
import com.developer.api.repositorio.LinkRepositorio;

@Configuration
@Profile("teste")
public class TesteConfig  implements CommandLineRunner{
	
	@Autowired
	private LinkRepositorio linkRepositorio;

	@Override
	public void run(String... args) throws Exception {
		Link link = new Link("www.teste./dasdsa/dasasdas", "endereco.com");
		Link link2 = new Link("www.desenv./dasdsa/dasasdas", "endereco2.com");
		linkRepositorio.saveAll(Arrays.asList(link, link2));	
	}
	
	
}
