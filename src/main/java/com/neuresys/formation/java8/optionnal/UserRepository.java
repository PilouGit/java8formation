package com.neuresys.formation.java8.optionnal;

import java.util.Optional;

public class UserRepository {

	public User getUserById(Long id)
	{
		// chercher le user dans la base ou l'id est celui du user.
		// si c'esttrouvé
		User u=new User();
		return u;
		
		// sinon si c'est pas trouvé
		
		//return null;
	}
	@SuppressWarnings("unused")
	public Optional<User> getUserByIdOptionnalManer(Long id)
	{
		User u=new User();
		if (u==null)
		{
			return Optional.empty();
		}else
		{
			return Optional.of(u);
		}
		
	}
}
