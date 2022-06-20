package com.neuresys.formation.java8.lambda.memberfunction;

import java.util.ArrayList;
import java.util.List;

public class Exercice {

	public static void main(String [] args)
	{
		List<Person> personList=new ArrayList<>();
		for (int i=0;i<100;i++) personList.add(new Person());
		personList.sort(new PersonAgeComparator());
		personList.sort((Person a, Person b) -> {
	        return a.getBirthday().compareTo(b.getBirthday());
	    });
		personList.sort( (a, b) -> Person.compareByAge(a, b));
		personList.sort( Person::compareByAge);
	}
}
