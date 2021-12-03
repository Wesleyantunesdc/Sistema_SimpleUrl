package com.developer.api.servicos;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.api.entidades.Link;
import com.developer.api.excecoes.BadRequestException;
import com.developer.api.repositorio.LinkRepositorio;

@Service
public class LinkServico {

	@Autowired
	private LinkRepositorio linkRepositorio;
	
	
//	public boolean linkJaCadastrado(String link) {
//		return linkRepositorio.existByUrlOriginal(link);
//	}
	
	public List<Link> listarTodos(){
		return linkRepositorio.findAll();
	}
	
	public Link obterPelaChave(String chave) {
		return linkRepositorio.findById(chave).orElseThrow(() -> new BadRequestException("Chave nao encontrada"));
	}
	
	public Link salvar(Link link) {
		if(link.getUrlOriginal() == null || link.getUrlOriginal().isEmpty() ) {
			new BadRequestException("O link original nao pode estar vazio");
		}
		gerarLinkCurto(link);
		return linkRepositorio.save(link);
	}
	
	private void gerarLinkCurto(Link link) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		link.setCodigo(uuid);
	}
}
