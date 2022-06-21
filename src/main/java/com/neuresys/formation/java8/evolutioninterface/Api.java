package com.neuresys.formation.java8.evolutioninterface;

public interface Api {

	User getUserFromId(Long id);
	
	default void deleteUserFromId(Long id)
	{
		
	}
	
}
