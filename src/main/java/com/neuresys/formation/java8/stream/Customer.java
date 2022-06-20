package com.neuresys.formation.java8.stream;

public class Customer {
	 private Long id;
	  
	  private String name;
	  private Integer tier;
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
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, tier=%s]", id, name, tier);
	}
	public Customer(Long id, String name, Integer tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
	}
	  
}
