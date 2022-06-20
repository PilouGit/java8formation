package com.neuresys.formation.java8.parallelestream;

import java.util.stream.IntStream;

public class SimpleParallele {

	    public static void main(String[] args) {

	        System.out.println("Normal...");
	      
			IntStream range = IntStream.rangeClosed(1, 10);
	        range.parallel().forEach(System.out::println);

	        /*System.out.println("Parallel...");

	        IntStream range2 = IntStream.rangeClosed(1, 10);
	        range2.parallel().forEach(System.out::println);
*/
	    }

	
}
