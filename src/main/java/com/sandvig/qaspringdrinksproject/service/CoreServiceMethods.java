package com.sandvig.qaspringdrinksproject.service;

import java.util.List;

public interface CoreServiceMethods<T> {
	//Create
	T create (T t);
		
	//Read All
	List<T> getAll();
	
	//Read By ID
	T getByID(long id);
	
	//Update
	T update(long id, T t);
	
	//Delete
	boolean delete(long id);
}
