package com.sandvig.qaspringdrinksproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Test
	public void testGetById() {
		long testInputValid = 3L;
		long testInputInvalid = 4L;
		Optional<Drink> mockOutputValid = 
				Optional.ofNullable(new Drink(3L, "DnB", 330, true, 333));
		Optional<Drink> mockOutputInvalid = Optional.ofNullable(null);
		
		Mockito.when(this.drinkRepo.findById(testInputValid)).
												thenReturn(mockOutputValid);
		Mockito.when(this.drinkRepo.findById(testInputInvalid)).
												thenReturn(mockOutputInvalid);
		
		assertEquals(mockOutputValid.get(), this.drinkService.getByID(testInputValid));
		assertEquals(null, this.drinkService.getByID(testInputInvalid));
		
		Mockito.verify(this.drinkRepo, Mockito.times(1)).findById(testInputValid);
		Mockito.verify(this.drinkRepo, Mockito.times(1)).findById(testInputInvalid);
	}
	
	@Test
	public void testUpdate() {
		long testInputIdValid = 4L;
		long testInputIdInvalid = 5L;
		Drink testInputDrink = new Drink("Orange Juice", 1000, false, 332);
		
		Optional<Drink> mockOutputValid = 
				Optional.ofNullable(new Drink(4L, "Orange Juice", 1000, false, 333));
		Optional<Drink> mockOutputInvalid = Optional.ofNullable(null);
		Drink methodResult = new Drink(4L, "Orange Juice", 1000, false, 332);
		
		Mockito.when(this.drinkRepo.findById(testInputIdValid)).
												thenReturn(mockOutputValid);
		Mockito.when(this.drinkRepo.saveAndFlush(methodResult)).
												thenReturn(methodResult);
		Mockito.when(this.drinkRepo.findById(testInputIdInvalid)).
												thenReturn(mockOutputInvalid);
		
		assertEquals(methodResult, 
				this.drinkService.update(testInputIdValid, testInputDrink));
		assertEquals(null, 
				this.drinkService.update(testInputIdInvalid, testInputDrink));
		
		Mockito.verify(this.drinkRepo, Mockito.times(1)).findById(testInputIdValid);
		Mockito.verify(this.drinkRepo, Mockito.times(1)).saveAndFlush(methodResult);
		Mockito.verify(this.drinkRepo, Mockito.times(1)).findById(testInputIdInvalid);
	}
	
	@Test
	public void testDelete() {
		long testInput= 5L;
		
		Mockito.when(this.drinkRepo.existsById(testInput)).thenReturn(false);
		
		assertEquals(true, this.drinkService.delete(testInput));
		
		Mockito.verify(this.drinkRepo, Mockito.times(1)).deleteById(testInput);
		Mockito.verify(this.drinkRepo, Mockito.times(1)).existsById(testInput);		
	}

}
