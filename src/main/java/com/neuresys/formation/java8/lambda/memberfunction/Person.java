package com.neuresys.formation.java8.lambda.memberfunction;

import java.time.LocalDate;
import java.util.Random;

public class Person {
	public static Random random=new Random();
LocalDate birthday=LocalDate.now().minusDays(random.nextInt(300));
    
    public int getAge() {
        return 0;
    }
    
    public LocalDate getBirthday() {
        return birthday;
    }   

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
}
