package com.neuresys.formation.java8.stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercice {

	//Obtenir une liste de produits appartenant à la catégorie "Livres" avec un prix > 100
	public static void exercice1()
	{
		List<Product> result = Repo.findAllProduct()
				  .stream()
				  .filter(p -> p.getCategory().equalsIgnoreCase("Livres"))
				  .filter(p -> p.getPrice() > 100)
				  .collect(Collectors.toList());
		System.out.println(result);
	}
	//Obtenir une liste de commandes avec des produits appartenant à la catégorie "Bébé"
	public static void exercice2()
	{
		List<Order> result = Repo.findAllOrder()
		        .stream()
		        .filter(o -> 
		          o.getProducts()
		          .stream()
		          .anyMatch(
		        		  p -> p.getCategory().equalsIgnoreCase("Bébé"))
		        )
		        .collect(Collectors.toList());
		System.out.println(result);
	}
	//Obtenez une liste de produits avec la catégorie = "Jouets" puis appliquez une remise de 10 %
	public static void exercice3()
	{
		List<Product> result = Repo.findAllProduct()
		        .stream()
		        .filter(p -> p.getCategory().equalsIgnoreCase("Jouets"))
		        .map(p -> p.withPrice(p.getPrice() * 0.9))
		        .collect(Collectors.toList());
		System.out.println(result);
	}
	//Obtenir une liste des produits commandés par les clients du niveau 2 entre le 1er février 2021 et le 1er avril 2021
	public static void exercice4()
	{
		List<Product> result =Repo.findAllOrder()
				  .stream()
				  .filter(o -> o.getCustomer().getTier() == 2)
				  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				  .flatMap(o -> o.getProducts().stream())
				  .distinct()
				  .collect(Collectors.toList());
		List<Product> result2 =Repo.findAllOrder()
				  .stream()
				  .filter(o -> 
				  {return o.getCustomer().getTier() == 2
				  && o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0
				  && o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0;
				  })
				  //.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				 // .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				  .flatMap(o -> o.getProducts().stream())
				  .distinct()
				  .collect(Collectors.toList());
	}
	// Obtenir le produit le moins cher de la catégorie « Livres »
		public static void exercice5() {
			Optional<Product> result =  Repo.findAllProduct()
			        .stream()
			        .filter(p -> p.getCategory().equalsIgnoreCase("Livres"))
			        .sorted(Comparator.comparing(Product::getPrice))
			        .findFirst();
		}
		//Obtenir les 3 dernières commandes passées
		public static void exercice6() {
			List<Order> result = Repo.findAllOrder()
			        .stream()
			        .sorted(Comparator.comparing(Order::getOrderDate).reversed())
			        .limit(3)
			        .collect(Collectors.toList());
		}
		//Obtenez une liste des commandes qui ont été commandées le 15 mars 2021, enregistrez les enregistrements de commande sur la console, puis renvoyez sa liste de produits
	public static void exercice7() {
		List<Product> result = Repo.findAllOrder()
			    .stream()
			    .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
			    .peek(o -> System.out.println(o.toString()))
			    .flatMap(o -> o.getProducts().stream())
			    .distinct()
			    .collect(Collectors.toList());
	}
	//Calculer la somme forfaitaire totale de toutes les commandes passées en février 2021
	public static void exercice8() {
		Double result =  Repo.findAllOrder()
			    .stream()
			    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
			    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
			    .flatMap(o -> o.getProducts().stream())
			    .mapToDouble(p -> p.getPrice())
			    .sum();
	}
	//Calculer le paiement moyen d'une commande passée le 14 mars 2021
	public static void exercice9() {
		Double result = Repo.findAllOrder()
		        .stream()
		        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
		        .flatMap(o -> o.getProducts().stream())
		        .mapToDouble(p -> p.getPrice())
		        .average().getAsDouble();
	}
	//Obtenir une collection de chiffres statistiques (c'est-à-dire somme, moyenne, max, min, nombre) pour tous les produits de la catégorie "Livres"
	public static void exercice10()
	{
		DoubleSummaryStatistics statistics = Repo.findAllProduct()
			    .stream()
			    .filter(p -> p.getCategory().equalsIgnoreCase("Livres"))
			    .mapToDouble(p -> p.getPrice())
			    .summaryStatistics();
			  
			  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
			    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
	}
	//Obtenir une carte de données avec l'identifiant de la commande et le nombre de produits de la commande
	// Map<Id Commande, Nombre de produit de la commande
	// .collect(toMap(commande-> id, commande-> nombre de produit))
	
		public static void exercice11()
		
		{
			Map<Long, Integer>  result = Repo.findAllOrder()
			        .stream()
			        .collect(
			            Collectors.toMap(
			                order -> order.getId(),
			                order -> order.getProducts().size()
			                )
			            );
		}
		// Produire une carte de données avec des enregistrements de commande regroupés par client
		public static void exercice12() {
			Map<Customer, List<Order>> result =Repo.findAllOrder()
			        .stream()
			        .collect(
			            Collectors.groupingBy(Order::getCustomer)
			            );
		}
		//Produire une carte de données avec l'enregistrement de la commande et la somme totale des produits
		public static void exercice13() {
			Map<Order, Double> result =Repo.findAllOrder()
			        .stream()
			        .collect(
			          Collectors.toMap(
			              Function.identity(), 
			              order -> order.getProducts().stream()
			                    .mapToDouble(p -> p.getPrice()).sum()
			            ) 
			          );
			Map<Order, Double> result2 =Repo.findAllOrder()
			        .stream()
			        .collect(
			          Collectors.toMap(
			              order->order, 
			              order -> order.getProducts().stream()
			                    .mapToDouble(p -> p.getPrice()).sum()
			            ) 
			          );
		}
		//Obtenir une carte de données avec la liste des noms de produits par catégorie
		public static void exercice14() {
			Map<String, List<String>> result =Repo.findAllProduct()
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			                Product::getCategory,
			                Collectors.mapping(product -> product.getName(), Collectors.toList()))
			            );
		}
		//Obtenez le produit le plus cher par catégorie
		public static void exercice15() {
			Map<String, Optional<Product>> result = Repo.findAllProduct()
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			                Product::getCategory,
			                Collectors.maxBy(Comparator.comparing(Product::getPrice))));
			 System.out.println(result);
		}
	public static void main(String [] args)
	{
		exercice15();
		
	}
}
