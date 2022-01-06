package com.sandvig.qaspringdrinksproject.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class DrinkUnitTests {
	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Drink.class).usingGetClass().verify();
	}
	
	@Test
	public void testConstructorWithId() {
		Drink drink = new Drink(1L, "Fanta", 1000, true, 333);
		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getVolumeMl());
		assertNotNull(drink.isCarbonated());
		assertNotNull(drink.getStock());
		
		assertEquals(1L, drink.getId());
		assertEquals("Fanta", drink.getName());
		assertEquals(1000, drink.getVolumeMl());
		assertEquals(true, drink.isCarbonated());
		assertEquals(333, drink.getStock());		
	}
	
	@Test 
	public void testConstructorWithoutId() {
		Drink drink = new Drink("Ginger Beer", 1000, true, 333);
		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getVolumeMl());
		assertNotNull(drink.isCarbonated());
		assertNotNull(drink.getStock());
		
		assertEquals(0L, drink.getId());
		assertEquals("Ginger Beer", drink.getName());
		assertEquals(1000, drink.getVolumeMl());
		assertEquals(true, drink.isCarbonated());
		assertEquals(333, drink.getStock());
	}
	
	@Test
	public void testSetters() {
		Drink drink = new Drink();
		
		drink.setId(3L);
		drink.setName("Fanta");
		drink.setVolumeMl(1000);
		drink.setCarbonated(true);
		drink.setStock(333);
		
		assertNotNull(drink.getId());
		assertNotNull(drink.getName());
		assertNotNull(drink.getVolumeMl());
		assertNotNull(drink.isCarbonated());
		assertNotNull(drink.getStock());
		
		assertEquals(3L, drink.getId());
		assertEquals("Fanta", drink.getName());
		assertEquals(1000, drink.getVolumeMl());
		assertEquals(true, drink.isCarbonated());
		assertEquals(333, drink.getStock());
	}
	
	@Test
	public void testToString() {
		Drink drink = new Drink("Fanta", 1000, true, 333);
		
		assertNotNull(drink.toString());
		
		assertEquals(
			"Drink [id=0, name=Fanta, volumeMl=1000, carbonated=true, stock=333]",
			drink.toString());
	}
}
