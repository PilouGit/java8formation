package com.neuresys.formation.java8.lambda.simple;

public class Factory {
    public String createName(String firstName, String lastName) {
        return firstName+lastName;
    }
    public static String createNameStatic(String firstName, String lastName) {
        return firstName+lastName;
    }

}
