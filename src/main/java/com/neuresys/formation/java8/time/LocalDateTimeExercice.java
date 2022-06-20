package com.neuresys.formation.java8.time;

import java.util.*;


public class LocalDateTimeExercice {
//Ecrire un programme Java pour créer un objet Date en utilisant la classe Calendar
	  public static void exercice1(String[] args)
	    {
	     int year = 2016;
	     int month = 0; // January
	     int date = 1;

	     Calendar cal = Calendar.getInstance();
	     // Sets the given calendar field value and the time value
	     // (millisecond offset from the Epoch) of this Calendar undefined.
	     cal.clear();
	     System.out.println();
	     cal.set(Calendar.YEAR, year);
	     cal.set(Calendar.MONTH, month);
	     cal.set(Calendar.DATE, date);

	     System.out.println(cal.getTime());
	     System.out.println();
		 }
	  //Écrire un programme Java pour obtenir et afficher les informations (année, mois, jour, heure, minute) d'un calendrier par défaut
	  public static void exercice2(String[] args)
	    {
	       // Create a default calendar
	        Calendar cal = Calendar.getInstance();
	       // Get and display information of current date from the calendar:
		    System.out.println();
	        System.out.println("Year: " + cal.get(Calendar.YEAR));
	        System.out.println("Month: " + cal.get(Calendar.MONTH));
	        System.out.println("Day: " + cal.get(Calendar.DATE));
	        System.out.println("Hour: " + cal.get(Calendar.HOUR));
	        System.out.println("Minute: " + cal.get(Calendar.MINUTE));
		    System.out.println();
	    }
	  //Écrivez un programme Java pour obtenir la valeur maximale de l'année, du mois, de la semaine et de la date à partir de la date actuelle d'un calendrier par défaut.
	  public static void exercice3(String[] args)
	    {
	     // Create a default calendar
	        Calendar cal = Calendar.getInstance();
			System.out.println();
			System.out.println("\nCurrent Date and Time:" + cal.getTime());		
			int actualMaxYear = cal.getActualMaximum(Calendar.YEAR);
			int actualMaxMonth = cal.getActualMaximum(Calendar.MONTH);
			int actualMaxWeek = cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
			int actualMaxDate = cal.getActualMaximum(Calendar.DATE);
			
			System.out.println("Actual Maximum Year: "+actualMaxYear);
			System.out.println("Actual Maximum Month: "+actualMaxMonth);
			System.out.println("Actual Maximum Week of Year: "+actualMaxWeek);
			System.out.println("Actual Maximum Date: "+actualMaxDate+"\n");
			System.out.println();
			
		  }
	  //Écrivez un programme Java pour obtenir la valeur minimale de l'année, du mois, de la semaine et de la date à partir de la date actuelle d'un calendrier par défaut.
	  public static void exercice4(String[] args)
	  {
		     // Create a default calendar
		        Calendar cal = Calendar.getInstance();
				System.out.println();
				System.out.println("\nCurrent Date and Time:" + cal.getTime());		
				int actualMaxYear = cal.getActualMinimum(Calendar.YEAR);
				int actualMaxMonth = cal.getActualMinimum(Calendar.MONTH);
				int actualMaxWeek = cal.getActualMinimum(Calendar.WEEK_OF_YEAR);
				int actualMaxDate = cal.getActualMinimum(Calendar.DATE);
				
				System.out.println("Actual Minimum Year: "+actualMaxYear);
				System.out.println("Actual Minimum Month: "+actualMaxMonth);
				System.out.println("Actual Minimum Week of Year: "+actualMaxWeek);
				System.out.println("Actual Minimum Date: "+actualMaxDate+"\n");
				System.out.println();		
			  }
}