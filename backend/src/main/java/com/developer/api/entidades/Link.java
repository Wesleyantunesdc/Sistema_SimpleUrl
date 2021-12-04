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
	@Column(nullable = false, length = 1000)
	private String codigo;
	@Column(nullable = false, length = 1000)
	private String urlOriginal;

	
	public Link() {
	}

	public Link(String codigo, String urlOriginal) {
		super();
		this.urlOriginal = urlOriginal;
		this.codigo = codigo;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, urlOriginal);
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
		return Objects.equals(codigo, other.codigo) && Objects.equals(urlOriginal, other.urlOriginal);
	}
}
