package com.neuresys.formation.java8.lambda.etudiant;

public class Exercice {

	public static void main(String [] args)
	{
		Etudiant e=()->{
			System.err.println("ici");
		};
		e.donnerNom();
		  EtudiantEvolue et = (leNomAafficher) -> {System.out.println("Je me nomme " + leNomAafficher);};
		   et.donnerNom("Je me nomme Jean");//Cette fois, on affichera Jean
	}
}
