package com.sandvig.qaspringdrinksproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sandvig.qaspringdrinksproject.domain.Drink;
import com.sandvig.qaspringdrinksproject.repo.DrinkRepo;

@Service
public class DrinkService implements CoreServiceMethods<Drink> {

	private DrinkRepo drinkRepo;
	
	public DrinkService(DrinkRepo drinkRepo) {
		this.drinkRepo = drinkRepo;
	}
	
	@Override
	public Drink create(Drink drink) {
		return this.drinkRepo.save(drink);
	}

	@Override
	public List<Drink> getAll() {
		return this.drinkRepo.findAll();
	}

	//Optional of type allows for result to be null without throwing exception
	@Override
	public Drink getByID(long id) {
		Optional<Drink> optionalDrink = this.drinkRepo.findById(id);
		if (optionalDrink.isPresent()) {
			return optionalDrink.get();
		}
		return null;
	}
	
	//Optional of type allows for result to be null without throwing exception
	@Override
	public Drink update(long id, Drink updatedDrink) {
		Optional<Drink> optionalDrink = this.drinkRepo.findById(id);
		if (optionalDrink.isPresent()) {
			Drink existingDrink = optionalDrink.get();
			existingDrink.setName(updatedDrink.getName());
			existingDrink.setVolumeMl(updatedDrink.getVolumeMl());
			existingDrink.setCarbonated(updatedDrink.isCarbonated());
			existingDrink.setStock(updatedDrink.getStock());
			
			return this.drinkRepo.saveAndFlush(existingDrink);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.drinkRepo.deleteById(id);
		
		//Returns True if the id in question no longer exists in the table
				boolean exists = this.drinkRepo.existsById(id);
				return !exists;
	}

}
