package com.developer.api.recursos;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developer.api.entidades.Link;
import com.developer.api.servicos.LinkServico;

@RestController
public class LinkRecurso {

	@Autowired
	private LinkServico linkServico;

	@PostMapping
	public ResponseEntity<Link> gerarLink(@RequestBody Link link) {
		return new ResponseEntity<Link>(linkServico.salvar(link), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{codigo}")
	public void teste(@PathVariable String codigo, HttpServletResponse response) {
		Link obj = linkServico.obterPelaChave(codigo);
		redirecionar(response, obj.getUrlOriginal());
	}
	

	public void redirecionar(HttpServletResponse response, String endereco) {
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", endereco);
		response.setHeader("Connection", "close");
	}

}
