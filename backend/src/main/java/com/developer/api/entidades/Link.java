package com.developer.api.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Link implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false)
	private String urlOriginal;
	@Column(nullable = false)
	private String urlResumida;
	
	public Link() {
	}

	public Link(String urlOriginal, String urlResumida) {
		super();
		this.urlOriginal = urlOriginal;
		this.urlResumida = urlResumida;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getUrlResumida() {
		return urlResumida;
	}

	public void setUrlResumida(String urlResumida) {
		this.urlResumida = urlResumida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(urlOriginal, urlResumida);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		return Objects.equals(urlOriginal, other.urlOriginal) && Objects.equals(urlResumida, other.urlResumida);
	}
}
