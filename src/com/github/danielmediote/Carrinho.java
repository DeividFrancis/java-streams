package com.github.danielmediote;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Carrinho {

	private static final List<Produto> produtoList = new ArrayList<Produto>();
	
	static {
		produtoList.add(new Produto(744, "Redragon Kumara", 			new BigDecimal(243.35), 	"Tecnologia", 	true)	);
		produtoList.add(new Produto(850, "Redragon Cobra" ,				new BigDecimal(190.20), 	"Tecnologia", 	true)	);
		produtoList.add(new Produto(022, "SSD M.2" , 					new BigDecimal(102.02), 	"Tecnologia", 	true)	);
		produtoList.add(new Produto(022, "SSD M.2" , 					new BigDecimal(102.02), 	"Tecnologia", 	true)	);
		produtoList.add(new Produto(848, "Monitor 24p 165hz" , 			new BigDecimal(1153.00), 	"Tecnologia", 	false)	);
		produtoList.add(new Produto(254, "Oculos de ciclismo" , 		new BigDecimal(104.02), 	"Esporte",		true)	);
		produtoList.add(new Produto(78, "Molinete de pesca" , 			new BigDecimal(175.00), 	"Esporte", 		false)	);
		produtoList.add(new Produto(678, "Tenis allstar" , 				new BigDecimal(167.00), 	"Vestuário", 	true)	);
		produtoList.add(new Produto(403, "Luva de motociclista" , 		new BigDecimal(134.00), 	"Vestuário", 	false)	);
		produtoList.add(new Produto(625, "chave de fenda magnética" , 	new BigDecimal(55.00), 		"Equipamentos", true)	);
		produtoList.add(new Produto(573, "Tapete Geometrico" , 			new BigDecimal(114.00), 	"Lazer", 		true)	);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		atividadeA();
		atividadeB();
		atividadeC();
		atividadeD();
		atividadeF();
		atividadeG();
		atividadeH();
		atividadeI();
		atividadeL();
	}
	
	private static void atividadeL() {
		System.out.println("\nProdutos com ID 850, 403, 625.");
		List<Produto> prodList = produtoList.stream()
				.filter(prod -> {
					Integer[] ids = {850, 403, 625};
					if (Arrays.stream(ids).anyMatch(prod.getId()::equals)) return true;
					else return false;
				})
				.collect(Collectors.toList());
		
		listarProdutos(prodList);
	}

	private static void atividadeI() {
		
		Produto produto = produtoList.stream()
					.sorted((prodA , prodB) -> prodA.getValor().compareTo(prodB.getValor()))
	                .findFirst()
	                .orElse(null);
	                
	    if (produto != null ){
	    	System.out.println("Categoria com produto mais caro é "+produto.getCategoria());
	    }
		
	}

	private static void atividadeH() {
		System.out.println("\n Grupo por Categoria");
		Map<String, List<Produto>> prodMap = produtoList.stream()
				.collect(Collectors.groupingBy(Produto::getCategoria));
		
		for (String categoria: prodMap.keySet()) {
			System.out.println("\nCategoria "+ categoria);
			listarProdutos(prodMap.get(categoria));
		}
		
	}

	private static void atividadeG() {
		System.out.println("\nLista de Produtos em ordem Alfabética");
		List<Produto> prodList = produtoList.stream()
				.sorted(Comparator.comparing(Produto::getNome, String.CASE_INSENSITIVE_ORDER) )
				.collect(Collectors.toList());
		listarProdutos(prodList);
	}

	private static void atividadeF() {
		Produto produto = produtoList.stream()
				.filter(prod -> prod.getCategoria().equals("Equipamentos"))
				.findFirst()
				.orElse(null);
		if (produto != null) {			
			System.out.println("\nPrimeiro produto da categoria Equipamentos: ");
			System.out.println("===========================================================");
			System.out.println("ID - Nome do Produto (Categoria) [Estoque] - Preço ");
			System.out.println("===========================================================");
			String temEstoqueDesc = produto.getTemEstoque() ? "SIM" : "NÃO";
			BigDecimal preco = produto.getValor().round(new MathContext(5));
			System.out.println(produto.getId() + " - "+produto.getNome()+" ("+produto.getCategoria()+") ["+temEstoqueDesc+"] | R$ "+preco );
		}
		
	}

	private static void atividadeD() {
		BigDecimal somaTotalEsporte = produtoList.stream().filter(prod -> prod.getCategoria().equals("Esporte"))
				.map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("\nValor total dos Prod. Esportivos: R4 "+somaTotalEsporte.round(new MathContext(5)));
		
	}

	private static void atividadeC() {
		List<String> apenasNomesList = produtoList.stream().map(Produto::getNome).collect(Collectors.toList());
		System.out.println("\nLista com apenas os Nomes do Produto");
		for (String nome : apenasNomesList) {
			System.out.println("Nome:  "+nome);
}
		
	}

	private static void atividadeB() {
		System.out.println("\nProdutos com Estoque e acima de R$ 200");
		List<Produto> prodFiltroListB = produtoList.stream()
													.filter(prod -> prod.getTemEstoque() == true)
													.filter(prod -> prod.getValor().compareTo(new BigDecimal(200.00)) == 1)
													.collect(Collectors.toList());
		listarProdutos(prodFiltroListB);
		
	}

	private static void atividadeA() {
		List<Produto> prodFiltroListA = produtoList.stream().filter(prod -> prod.getCategoria().equals("Tecnologia"))
				.collect(Collectors.toList());
		System.out.println("Produtos de Categoria: Tecnologia");
		listarProdutos(prodFiltroListA);
		
	}

	public static void listarProdutos(List<Produto> prodList) {
		System.out.println("===========================================================");
		System.out.println("ID - Nome do Produto (Categoria) [Estoque] - Preço ");
		System.out.println("===========================================================");
		for(Produto prod : prodList) {
			String temEstoqueDesc = prod.getTemEstoque() ? "SIM" : "NÃO";
			BigDecimal preco = prod.getValor().round(new MathContext(5));
			System.out.println(prod.getId() + " - "+prod.getNome()+" ("+prod.getCategoria()+") ["+temEstoqueDesc+"] | R$ "+preco );
		}
	}
}
