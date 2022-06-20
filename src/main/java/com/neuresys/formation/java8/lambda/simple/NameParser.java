package com.neuresys.formation.java8.lambda.simple;

public class NameParser {
	  public  String parse(String name, Creator creator) {
		  String [] arrayString=name.split(" ");
		  
		  return creator.create(arrayString[0],
				  arrayString[1]);
	  }

	

	
	  
}