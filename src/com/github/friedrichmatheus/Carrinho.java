package com.github.friedrichmatheus;

import java.math.BigDecimal;

public class Carrinho {
	
	public enum Categoria {
		Tecnologia, Esporte, Vestuario, Equipamentos, Lazer
	}
	
	Integer id;
	String nome;
	BigDecimal valor;
	Boolean temEstoque;
	Categoria categoria;
	
	public Carrinho(Integer id, String nome, BigDecimal valor, Boolean temEstoque, Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.temEstoque = temEstoque;
		this.categoria = categoria;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Boolean getTemEstoque() {
		return temEstoque;
	}
	public void setTemEstoque(Boolean temEstoque) {
		this.temEstoque = temEstoque;
	}
	
	
}
