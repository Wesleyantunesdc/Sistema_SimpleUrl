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
		Link link = new Link("1", "https://www.youtube.com/watch?v=AzbydpkeHtk");
		Link link2 = new Link("2", "https://www.youtube.com/watch?v=Ywq6FMLbWH4&list=RDApXoWvfEYVU&index=13");
		Link link3 = new Link("3", "https://www.udemy.com/course/java-curso-completo/learn/lecture/16124057#overview");
		Link link4 = new Link("4", "https://id.heroku.com/login");
		linkRepositorio.saveAll(Arrays.asList(link, link2, link3, link4));	
	}
	
	
}
