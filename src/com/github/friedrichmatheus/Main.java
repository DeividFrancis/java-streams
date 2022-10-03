package com.github.friedrichmatheus;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.github.deividfrancis.Person;
import com.github.friedrichmatheus.Carrinho.Categoria;

public class Main {

	private static List<Carrinho> carrinhoList = new ArrayList<Carrinho>();

	static {
		carrinhoList.add(new Carrinho(744, "Redragon Kumara", new BigDecimal(243.35), Boolean.TRUE, Categoria.Tecnologia));
		carrinhoList.add(new Carrinho(850, "Redragon Cobra", new BigDecimal(190.20), Boolean.TRUE, Categoria.Tecnologia));
		carrinhoList.add(new Carrinho(22, "SSD M.2", new BigDecimal(102.02), Boolean.TRUE, Categoria.Tecnologia));
		carrinhoList.add(new Carrinho(848, "Monitor 24p 165hz", new BigDecimal(1153.00), Boolean.FALSE, Categoria.Tecnologia));
		carrinhoList.add(new Carrinho(254, "Oculos de ciclismo", new BigDecimal(104.02), Boolean.TRUE, Categoria.Esporte));
		carrinhoList.add(new Carrinho(78, "Molinete de pesca", new BigDecimal(175.00), Boolean.FALSE, Categoria.Esporte));
		carrinhoList.add(new Carrinho(415, "Tenis allstar", new BigDecimal(167.00), Boolean.TRUE, Categoria.Vestuario));
		carrinhoList.add(new Carrinho(403, "Luva de motociclista", new BigDecimal(134.00), Boolean.FALSE, Categoria.Vestuario));
		carrinhoList.add(new Carrinho(625, "chave de fenda magnética", new BigDecimal(55.00), Boolean.TRUE, Categoria.Equipamentos));
		carrinhoList.add(new Carrinho(573, "Tapete Geometrico", new BigDecimal(114.00), Boolean.TRUE, Categoria.Lazer));
	}

	public static void main(String[] args) {
		//		getTecnologia();
		//		getValorMaior();
		//		getTemEstoque();
		//		getSumEsport();
		//		getEquipamento();
		//		getOrderList();
		//		getGroupByCategory();
//		getHighestPrice();
	}

	public static void getTecnologia() {
		List<String> carrinhoList = Main.carrinhoList.stream()
				.filter(c -> c.getCategoria() == Categoria.Tecnologia)
				.map(Carrinho::getNome)
				.collect(Collectors.toList());

		System.out.println(carrinhoList);
	}

	public static void getValorMaior() {
		List<String> carrinhoList = Main.carrinhoList.stream()
				.filter(c -> c.getValor().compareTo(new BigDecimal(200)) == 1)
				.map(Carrinho::getNome)
				.collect(Collectors.toList());

		System.out.println(carrinhoList);
	}

	public static void getTemEstoque() {
		List<String> carrinhoList = Main.carrinhoList.stream()
				.filter(c -> c.temEstoque)
				.map(Carrinho::getNome)
				.collect(Collectors.toList());

		System.out.println(carrinhoList);
	}

	public static void getSumEsport() {
		BigDecimal carrinhoList = Main.carrinhoList.stream()
				.filter(c -> c.getCategoria() == Categoria.Esporte)
				.map(Carrinho::getValor)
				.reduce(new BigDecimal(0),(a, n) -> a.add(n));

		System.out.println(carrinhoList.intValue());
	}

	public static void getEquipamento() {
		String carrinhoList = Main.carrinhoList.stream()
				.filter(c -> c.categoria == Categoria.Equipamentos)
				.map(Carrinho::getNome)
				.findFirst()
				.get();

		System.out.println(carrinhoList);
	}

	public static void getOrderList() {
		List<String> carrinhoList = Main.carrinhoList.stream()
				.map(Carrinho::getNome)
				.sorted()
				.toList();

		System.out.println(carrinhoList);
	}

	public static void getGroupByCategory() {
		Map<Carrinho.Categoria,List<Carrinho>> carrinhoMap = Main.carrinhoList.stream()
				.collect(Collectors.groupingBy(Carrinho::getCategoria));

		System.out.println(carrinhoMap);
	}

//	public static void getHighestPrice() {
//		Map<Carrinho, Map<Carrinho, BigDecimal>> carrinhoMap = Main.carrinhoList.stream()
//,Collectors.)));
//
//		System.out.println(carrinhoMap);
//	}
}
