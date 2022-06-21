package com.neuresys.formation.java8.evolutioninterface;

public class ApiImplForMocking implements Api{

	@Override
	public User getUserFromId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserFromId(Long id) {
		// TODO Auto-generated method stub
		Api.super.deleteUserFromId(id);
	}

}
