package com.github.danielmediote;

import java.math.BigDecimal;

public class Produto {

	private Integer id;
	private String nome;
	private BigDecimal valor;
	private String categoria;
	private Boolean temEstoque;

	public Produto(Integer id, String nome, BigDecimal valor, String categoria, Boolean temEstoque) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.categoria = categoria;
		this.temEstoque = temEstoque;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Boolean getTemEstoque() {
		return temEstoque;
	}

	public void setTemEstoque(Boolean temEstoque) {
		this.temEstoque = temEstoque;
	}

}
