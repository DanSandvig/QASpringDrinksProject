package com.sandvig.qaspringdrinksproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sandvig.qaspringdrinksproject.domain.Drink;
import com.sandvig.qaspringdrinksproject.repo.DrinkRepo;

@SpringBootTest
public class DrinkServiceUnitTests {
	
	@Autowired
	private DrinkService drinkService;
	
	@MockBean
	private DrinkRepo drinkRepo;
	
	@Test
	public void testCreate() {
		Drink testInput = new Drink("Fanta", 1000, true, 333);
		Drink mockOutput = new Drink(1L, "Fanta", 1000, true, 333);
		
		//Instructs the mocked component how to respond to a given method call
		Mockito.when(this.drinkRepo.save(testInput)).thenReturn(mockOutput);
		
		//Tests the method in the Service class
		assertEquals(mockOutput, this.drinkService.create(testInput));
		
		//Confirms the number of times the method call takes place
		Mockito.verify(this.drinkRepo, Mockito.times(1)).save(testInput);
	}
	
	@Test
	public void testGetAll() {
		List<Drink> mockOutput = new ArrayList<Drink>();
		mockOutput.add(new Drink(1L, "Fanta", 1000, true, 333));
		mockOutput.add(new Drink(2L, "Sprite", 1000, true, 333));
		
		Mockito.when(this.drinkRepo.findAll()).thenReturn(mockOutput);
		
		assertEquals(mockOutput, this.drinkService.getAll());
		
		Mockito.verify(this.drinkRepo, Mockito.times(1)).findAll();
	}

}
