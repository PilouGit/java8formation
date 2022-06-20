package com.neuresys.formation.java8.devoxxstream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercice {
	public <T> List<T> concatLists1(List<T>... lists) {
	    ArrayList<T> result = new ArrayList<>();
	    for (List<T> list : lists) {
	        result.addAll(list);
	    }
	    return result;
	}
	public <T> List<T> concatLists2(List<T>... lists) {
	    return Stream.of(lists).reduce(new ArrayList<>(), (list1, list2) -> {
	        list1.addAll(list2);
	        return list1;
	    });
	}
	public static <T> List<T> concatLists(List<T>... lists) {
	       return Stream.of(lists).flatMap(List::stream).collect(Collectors.toList());
	   }
}
