package com.neuresys.formation.java8.stream;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class Repo {

	static Random random=new Random();
	static Lorem lorem = LoremIpsum.getInstance();
	private static List<Customer> customerList;
	private static List<Product> productList;
	private static List<Order> orderList;
	public static void init()
	{
		if (customerList==null)
		{
			customerList= new ArrayList<Customer>();
			productList=new ArrayList<>();
			orderList=new ArrayList<>();
			String [] productCategorie= {"Jouet","Bébé","Livres","Autre"};
			
			for (int i=0;i<100;i++)
			{
				 Customer customer = new Customer(random.nextLong(),lorem.getName(),random.nextInt(3));
				customerList.add(customer);
			}
			for (int i=0;i<100;i++)
			{
				Product product=new Product(random.nextLong(),lorem.getCity(),productCategorie[random.nextInt(3)],random.nextDouble()*1000);
				productList.add(product);
			}
			for (int i=0;i<100;i++)
			{
				Order order=new Order();
				order.setId(random.nextLong());
				order.setOrderDate(LocalDate.now().minusDays(random.nextInt(5)));
				order.setDeliveryDate(LocalDate.now().plusDays(random.nextInt(5)));
				order.setCustomer(customerList.get(random.nextInt(100)));
				order.setStatus("ok");
				orderList.add(order);
				for (int j=0;j<10;j++)
				{
					Product product = productList.get(random.nextInt(100));
					product.getOrders().add(order);
					order.products.add(product);
				}

			}
			
		}
	}
	public static List<Customer> findAllCustomer(){
		init();
		return customerList;
		
		
	}
	public static List<Order> findAllOrder(){
		init();
		return orderList;
		
		
	}
	public static List<Product> findAllProduct(){
		init();
		return productList;
		
		
	}
}
