package com.developer.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.api.entidades.Link;

public interface LinkRepositorio extends JpaRepository<Link, String>{
	
	public boolean existsByUrlOriginal(String urlOriginal);
}
