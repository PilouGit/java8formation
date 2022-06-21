package com.neuresys.formation.java8.specialisation;

public class MaclasseDerive extends Maclasse{

	public MaclasseDerive()
	{
		this.setMonNom(null);
	}
	
	public static void main(String [] args)
	{
		Maclasse classe=                            new Maclasse();
		classe.afficheMonNom();
		MaclasseDerive deriver=                     new MaclasseDerive();
		deriver.afficheMonNom();
		Maclasse classe2=                           new MaclasseDerive();
		classe2.afficheMonNom();
	}
	
}
