package com.neuresys.formation.java8.optionnal;

import java.util.Optional;

public class TestUserRepo {

	public static void main(String [] args)
	{
		UserRepository repo=new UserRepository();
		User u=repo.getUserById(1L);
		// je travaille avec l'utilisateur u;
		
		if (u!=null)
		{
			// fais qqchose
		}else
		{
			//problem.
		}
		Optional<User> optionnalU = repo.getUserByIdOptionnalManer(1L);
		if (!optionnalU.isEmpty())
		{
			User u2=optionnalU.get();
		}
	}
}
