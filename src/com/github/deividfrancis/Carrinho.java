package com.github.deividfrancis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrinho {
	private static List<Produtos> produtoList = new ArrayList<Produtos>();

	static {
		produtoList.add(new Produtos(744, "Redragon Kumara"   	 , 243.35, "Tecnologia", 'S'));
		produtoList.add(new Produtos(850, "Redragon Cobra"    	 , 190.20, "Tecnologia", 'S'));
		produtoList.add(new Produtos(022, "SSD M.2"            	 , 102.02, "Tecnologia", 'S'));
		produtoList.add(new Produtos(848, "Monitor 24p 165hz" 	 , 1153.0, "Tecnologia", 'N'));
		produtoList.add(new Produtos(254, "Oculos de ciclismo"	 , 104.02, "Esporte"   , 'S'));
		produtoList.add(new Produtos(78,  "Molinete de pesca" 	 , 175.00, "Esporte"   , 'N'));
		produtoList.add(new Produtos(415, "Tenis allstar"	     , 167.00, "Vestuario" , 'S'));
		produtoList.add(new Produtos(403, "Luva de motociclista" , 134.00, "Vestuario" , 'N'));
		produtoList.add(new Produtos(625, "Chave de fenda magnética", 55.00, "Equipamentos", 'S'));
		produtoList.add(new Produtos(573, "Tapete Geometrico", 114.00, "Lazer", 'S'));
	}


	public static void main(String[] args) {
//				filtroTecnologia();
//       		filtroEstoqueValor200();
//              filtroTemEstoque();
//              filtroEsporte();
//				filtroPrimeiraEquipamentos();
//				agrupaAlfabetica();
	}


	private static void filtroTecnologia() {
		List<Produtos> produtoTempList = Carrinho.produtoList.stream()
				.filter(p -> "Tecnologia" == p.getCategoria())
				.collect(Collectors.toList());

		System.out.println(produtoTempList);
	}

	private static void filtroEstoqueValor200() {
		List<Produtos> produtoTempList = produtoList.stream()
				.filter(p -> 'S' == p.getTemEstoque() && p.getValor() > 200.00)
				.collect(Collectors.toList());

		System.out.println(produtoTempList);
	}

	private static void filtroTemEstoque() {
		List<Produtos> produtoTempList = produtoList.stream()
				.filter(p -> 'S' == p.getTemEstoque())
				.collect(Collectors.toList());

		produtoTempList.stream().forEach(p -> {
			System.out.println(p.getNome());
		});
	}

	private static void filtroEsporte() {
		Long produtoTempList = produtoList.stream()
				.filter(p -> "Esporte" == p.getCategoria())
				.collect(Collectors.counting());

		System.out.println(produtoTempList);
	}

	private static void filtroPrimeiraEquipamentos() {
		Produtos produtoTempList = produtoList.stream()
				.filter(p -> p.getCategoria() == "Equipamentos")
				.findFirst()
				.orElse(null);

		System.out.println(produtoTempList);
	}

	public static void agrupaAlfabetica() {
		List<Produtos> produtoTempList = produtoList.stream()
				.sorted((x1 , x2) -> x1.getNome().compareTo(x2.getNome()))
				.toList();

		System.out.println(produtoTempList);
	}
}



