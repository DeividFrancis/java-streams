package com.github.deividfrancis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	private static List<Person> personList = new ArrayList<Person>();

	static {
		personList.add(new Person(1, "Bob", 'M', 25));
		personList.add(new Person(2, "Alice", 'F', 18));
		personList.add(new Person(3, "John", 'M', 20));
		personList.add(new Person(4, "Michael", 'M', 32));
	}

	public static void main(String[] args) {
		imprimeTitulo("JAVA Streams");


		foreachNormal();
		foreachLambda();

		mapNormal();
		mapLambda();

		filterNormal();
		filterLambda();

		reduceNormal();
		reduceLambda();
		
		list2ArrayNormal();
		list2ArrayLambda();
		
		array2ListNormal();
		array2ListLambda();
		
		findFirstNormal();
		findFirstLambda();
		
		joinNormal();
		joinLambda();
		
		filtroCompostoNormal();
		filtroCompostoLambda();
		
		groupByNormal();
		groupByLambda();
	}



	private static void groupByLambda() {
		// link com mais exemplos: https://www.baeldung.com/java-groupingby-collector
		
		imprimeTitulo("groupByLambda");
		
		// Objetivo é agrupar Person pelo sex

		Map<Character, List<Person>> personMap = personList.stream().collect(Collectors.groupingBy(Person::getSex));
		
		System.out.println(personMap);
	}



	private static void groupByNormal() {
		imprimeTitulo("groupByNormal");
		
		// Objetivo é agrupar Person pelo sex
		
		Map<Character, List<Person>> personMap = new HashMap<Character, List<Person>>();
		
		for (Person p: personList) {
			Character sex = p.getSex();
			
			List<Person> pList = personMap.get(sex);
			if(pList == null) {
				pList = new ArrayList<Person>();
				personMap.put(sex, pList);
			}
			
			pList.add(p);
		}
		
		System.out.println(personMap);
	}



	private static void filtroCompostoLambda() {
		imprimeTitulo("filtroCompostoLambda");
		
		// Objetivo é mostrar somente os nomes das person do sexo masculino com age maior que 22;
		
		List<String> nomes = personList.stream()
				.filter(p -> p.getSex() == 'M')
				.filter(p -> p.getAge() > 22)
				.map(Person::getName)
				.collect(Collectors.toList());
		
		System.out.println(nomes);
	}



	private static void filtroCompostoNormal() {
		imprimeTitulo("filtroCompostoNormal");
		
		// Objetivo é mostrar somente os nomes das person do sexo masculino com age maior que 22;
		
		List<String> nomes = new ArrayList<String>();
		
		for (Person p : personList) {
			if('M' == p.getSex() && p.getAge() > 22) {
				nomes.add(p.getName());
			}
		}
		
		System.out.println(nomes);
	}



	private static void joinNormal() {
		imprimeTitulo("joinNormal");
		
		String temp = "";
		String nomes = "";
		
		for (Person p : personList) {
			nomes += temp + p.getName();
			temp = "-";
		}
		
		System.out.println(nomes);
	}



	private static void joinLambda() {
		imprimeTitulo("joinLambda");
		
		String nomes = personList.stream()
				.map(Person::getName)
				.collect(Collectors.joining("-"));
		
		System.out.println(nomes);
	}



	private static void findFirstLambda() {
		imprimeTitulo("findFirstLambda");
		
		// Objetivo e encontrar a primeira person que seja do sexo feminino;
		
		Person personFirst = personList.stream()
				.filter(p -> p.getSex() == 'F')
				.findFirst()
				.orElse(null);
		
		System.out.println(personFirst);
	}



	private static void findFirstNormal() {
		imprimeTitulo("findFirstNormal");
		
		// Objetivo e encontrar a primeira person que seja do sexo feminino;
		
		Person personFirst = null;
		for (Person p : personList) {
			if('M' == p.getSex()) continue;
			
			personFirst = p;
			break;
		}
		
		System.out.println(personFirst);
		
	}



	private static void array2ListLambda() {
		imprimeTitulo("array2ListLambda");
		
		Person[] personArr = personList.toArray(Person[]::new); // Faz de conta que foi criado do modo convencional
		
		List<Person> personTempList = Arrays.asList(personArr);
		
		
		System.out.println(personTempList);
	}
	
	private static void array2ListNormal() {
		imprimeTitulo("array2ListNormal");
		
		Person[] personArr = personList.toArray(Person[]::new); // Faz de conta que foi criado do modo convencional
		
		List<Person> personTempList = new ArrayList<Person>();
		
		for (Person p: personArr) {
			personTempList.add(p);
		}
		
		
		System.out.println(personTempList);
	}



	private static void list2ArrayLambda() {
		imprimeTitulo("list2ArrayLambda");
		
//		Person[] personArr = personList.toArray(new Person[personList.size()]);
//		Person[] personArr = personList.stream().toArray(Person[]::new);
		Person[] personArr = personList.toArray(Person[]::new); // recomendado
		
		for (Person p : personArr) {
			System.out.print(p);
		}
	}



	private static void list2ArrayNormal() {
		imprimeTitulo("list2ArrayNormal");
		
		Person[] personArr = new Person[personList.size()];
		for (int i = 0; i < personArr.length; i++) {
			personArr[i] = personList.get(i);
		}
		
		for (Person p : personArr) {
			System.out.print(p);
		}
	}



	private static void mapLambda() {
		imprimeTitulo("mapLambda");
		
		List<String> names = personList.stream()
				.map(Person::getName)
				.collect(Collectors.toList());
		
		System.out.println(names);
	}



	private static void mapNormal() {
		imprimeTitulo("mapNormal");
		
		List<String> names = new ArrayList<String>(); 
		for (Person p : personList) {
			names.add(p.getName());
		}
		
		System.out.println(names);
	}



	private static void foreachNormal() {
		imprimeTitulo("foreachNormal");
		
		for(Person p: personList) {
			System.out.println(p.getName());
		}
	}

	private static void foreachLambda() {
		imprimeTitulo("foreachLambda");
		
		personList.stream().forEach(p -> {
			System.out.println(p.getName());
		});
	}

	private static void filterNormal() {
		imprimeTitulo("filterNormal");
		
		// Objetivo e obter uma lista com todas as person do sexo masculino;
		
		List<Person> personTempList = new ArrayList<Person>();
		for (Person p : personList) {
			char sex = p.getSex();
			if('M' == sex) {
				personTempList.add(p);
			}
		}
		System.out.println(personTempList);
	}

	private static void filterLambda() {
		imprimeTitulo("filterLambda");
		
		// Objetivo e obter uma lista com todas as person do sexo masculino;
		
		List<Person> personTempList = personList.stream()
				.filter(p -> 'M' == p.getSex())
				.collect(Collectors.toList());

		System.out.println(personTempList);
	}

	private static void reduceNormal() {
		imprimeTitulo("reduceNormal");
		Integer total = 0;
		for(Person p: personList) {
			total += p.getAge();
		}
		
		System.out.println(total);
	}

	private static void reduceLambda() {
		imprimeTitulo("reduceLambda");
		Integer total = personList.stream()
				.map(Person::getAge) // pega somente a idade
				.reduce(0, (accumulator, next) -> accumulator + next); // soma a idade comecando a partir de 0
		
		System.out.println(total);
	}
	
	private static void imprimeTitulo(String titulo) {
		int width = 30;
		String token = "#";
		int space = (((titulo.length() + 2) - width) / 2) * -1;
		String titleFull = token + " ".repeat(space) + titulo + " ".repeat(space) + token;
		
		System.out.println("\n");
		System.out.println(token.repeat(width));
		System.out.println(titleFull);
		System.out.println(token.repeat(width));
	}
}
