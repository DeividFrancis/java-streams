package com.github.deividfrancis;

import java.math.BigDecimal;

public class Produtos {
	private Integer id;
	private String nome;
	private Double valor;
	private String categoria;
	private char temEstoque;
	
	public Produtos(Integer id, String name, Double valor, String categoria, char temEstoque) {
		this.id = id;
		this.nome = name;
		this.valor= valor;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public char getTemEstoque() {
		return temEstoque;
	}
	public void setTemEstoque(char temEstoque) {
		this.temEstoque = temEstoque;
	}
	
	@Override
	public String toString() {
		return "Id=" + id + ", Nome=" + nome + ", Valor=R$" + valor + ", categoria=" + categoria + ", temEstoque=" + temEstoque +"\n\n";
	}
}
