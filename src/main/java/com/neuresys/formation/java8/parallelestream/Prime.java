package com.neuresys.formation.java8.parallelestream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prime {

    public static void main(String[] args) {

    	long now=System.currentTimeMillis();
    	
        long count = Stream.iterate(0, n -> n + 1)
                .limit(10000)
                .filter(Prime::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);
        System.err.println("Time :" + (System.currentTimeMillis()-now));

	 now=System.currentTimeMillis();
    	
         count = Stream.iterate(0, n -> n + 1)
                .limit(10000)
                .parallel() 
                .filter(Prime::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);
        System.err.println("Time :" + (System.currentTimeMillis()-now));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }

}
