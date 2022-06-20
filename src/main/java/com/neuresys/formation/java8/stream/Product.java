package com.neuresys.formation.java8.stream;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {
	 private Long id;
	  
	  private String name;
	  private String category;
	  private Double price;
	  private Set<Order> orders=new HashSet<>();
	  
	  public Product(Long id, String name, String category, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return String.format("Product [id=%s, name=%s, category=%s, price=%s]", id, name, category, price
				);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	public Product withPrice(Double d)
	{
		this.price=d;
		return this;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	  
}
