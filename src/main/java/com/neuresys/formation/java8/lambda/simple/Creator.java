package com.neuresys.formation.java8.lambda.simple;

@FunctionalInterface
public interface Creator {
    String create(String firstName, String lastName);
}
