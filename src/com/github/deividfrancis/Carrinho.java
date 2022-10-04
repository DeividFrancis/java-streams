package com.github.deividfrancis;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Carrinho {

	private static List<Produto> produtoList = new ArrayList<Produto>(); 
	
	static {
		produtoList.add(new Produto(744, "Redragon Kumara", 243.35, "Tecnologia", true));
		produtoList.add(new Produto(850, "Redragon Cobra", 190.20,	"Tecnologia", true));
		produtoList.add(new Produto(22, "SSD M.2", 102.02, "Tecnologia", true));
		produtoList.add(new Produto(848, "Monitor 24p 165hz", 1153.00, "Tecnologia", false));
		produtoList.add(new Produto(254, "Oculos de ciclismo", 104.02, "Esporte", true));
		produtoList.add(new Produto(78, "Molinete de pesca", 175.00, "Esporte", false));
		produtoList.add(new Produto(415, "Tenis allstar", 167.00, "Vestuario", true));
		produtoList.add(new Produto(403, "Luva de motociclista", 134.00, "Vestuario", false));
		produtoList.add(new Produto(625, "chave de fenda magnética", 55.00,	"Equipamentos", true));
		produtoList.add(new Produto(573, "Tapete Geometrico", 114.00, "Lazer", true));
	}
	
	public static void main(String[] args) {

		// i. Crie uma lista somente com os produtos da categoria (Tecnologia);
		listarSomenteProdutosTecnologia();
		
		// ii. Crie uma lista contendo todos os produtos com estoque e com valor maior de 200 reais;
		listarSomenteProdutosComEstoque();
		
		// iii. Crie uma lista somente com os nomes dos produto com estoque;
		listarNomeDeProdutosEmEstoque();
		
		// iv. Faz a soma de todos os produtos da categoria (Esporte);
		somarTodosOsProdutosDaCategoriaEsporte();
		
		// v. Busca o primeiro produto da categoria (Equipamentos);
		buscarPrimeiroProdutoDaCategoriaEquipamentos();
		
		// vi. Ordenar a lista de produto por ordem alfabetica;
		listarProdutosPorOrdemAlfabetica();
		
		// vii. Agrupar todos produtos por categoria;
		listarProdutosPorCategoria();
		
		// viii. Mostrar a categoria onde estão os produtos mais caros;
		buscarCategoriaQueContemOsProdutosMaisCaros();

		// ix. Crie uma lista que contem somente os ids: 850, 403, 625;
		listarIdDosProdutosEscolhidos();
	}

	private static void listarSomenteProdutosTecnologia() {
		List<Produto> produtoTecnologiaList = produtoList.stream()
				.filter(p -> p.getCategoria().equals("Tecnologia"))
				.collect(Collectors.toList());
		
		produtoTecnologiaList.forEach(p -> produtoLog(p));
	}

	private static void listarSomenteProdutosComEstoque() {
		List<Produto> produtoEstoqueList = produtoList.stream()
				.filter(p -> p.getTemEstoque() == true)
				.filter(p -> p.getValor() > 200.00)
				.collect(Collectors.toList());
		
		produtoEstoqueList.forEach(p -> produtoLog(p));
	}
	
	private static void listarNomeDeProdutosEmEstoque() {
		List<String> nomeProdutoList = produtoList.stream()
				.filter(p -> p.getTemEstoque() == true)
				.map(Produto::getNome)
				.collect(Collectors.toList());
		
		nomeProdutoList.forEach(s -> System.out.println(s));
	}
	
	private static void somarTodosOsProdutosDaCategoriaEsporte() {
		Double totalEsporte = produtoList.stream()
				.map(Produto::getValor)
				.reduce(0.00, (accumulator, next) -> accumulator + next);
		
		System.out.println(totalEsporte);
	}

	private static void buscarPrimeiroProdutoDaCategoriaEquipamentos() {
		Produto primeiroProduto = produtoList.stream()
				.filter(p -> p.getCategoria().equals("Equipamentos"))
				.findFirst()
				.orElse(null);
		
		produtoLog(primeiroProduto);
	}

	private static void listarProdutosPorOrdemAlfabetica() {
		List<String> produtoAlfabeticoList = produtoList.stream()
				.map(p -> p.getNome().toLowerCase())
				.sorted()
				.collect(Collectors.toList());
		
		produtoAlfabeticoList.forEach(s -> System.out.println(s));
	}

	private static void listarProdutosPorCategoria() {
		Map<String, List<Produto>> produtoCategoriaMap = produtoList.stream()
				.collect(Collectors.groupingBy(Produto::getCategoria));

		produtoCategoriaMap.forEach((s, p) -> {
			System.out.println(s); 
			p.forEach(prod -> produtoLog(prod));
			System.out.println("-------------------");
		});
	}

	private static void buscarCategoriaQueContemOsProdutosMaisCaros() {
		Entry<String, Double> categoriaMaisCara = produtoList.stream()
				.collect(Collectors.groupingBy(Produto::getCategoria, 
						Collectors.summingDouble(Produto::getValor)))
				.entrySet()
				.stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.orElse(null);
		
		System.out.println(categoriaMaisCara.getKey() + " - " + categoriaMaisCara.getValue());
	}

	private static void listarIdDosProdutosEscolhidos() {
		Predicate<Integer> con1 = p -> p == 850;
		Predicate<Integer> con2 = p -> p == 403;
		Predicate<Integer> con3 = p -> p == 625;
		
		List<Integer> produtoIdList = produtoList.stream()
				.map(Produto::getId)
				.filter(con1.or(con2).or(con3))
				.collect(Collectors.toList());
		
		produtoIdList.forEach(System.out::println);
	}

	private static void produtoLog(Produto produto) {
		Integer id = produto.getId();
		String nome = produto.getNome();
		String categoria = produto.getCategoria();
		Double valor = produto.getValor();
		Boolean temEstoque = produto.getTemEstoque();
		
		System.out.println(id + " " + nome + " " + categoria + " " + valor + " " + temEstoque);
	}
}
