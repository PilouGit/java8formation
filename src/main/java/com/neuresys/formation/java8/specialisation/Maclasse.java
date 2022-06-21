package com.neuresys.formation.java8.specialisation;

public class Maclasse {

	private String monNom="";
	public void afficheMonNom()
	{
	
		System.out.println("Affiche "+monNom+" qui fait "+monNom.length());
	}
	public String getMonNom() {
		return monNom;
	}
	public void setMonNom( String monNom) {
		if (monNom!=null)
		this.monNom = monNom;
	}
	
}
