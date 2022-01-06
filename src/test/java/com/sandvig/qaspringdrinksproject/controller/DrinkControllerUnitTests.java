package com.sandvig.qaspringdrinksproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandvig.qaspringdrinksproject.domain.Drink;
import com.sandvig.qaspringdrinksproject.service.DrinkService;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class DrinkControllerUnitTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private DrinkService drinkService;
	
	@Test
	public void testCreate() throws Exception {
		Drink testDrink = new Drink("Tizer", 1000, true, 333);
		String testDrinkAsJson = this.mapper.writeValueAsString(testDrink);
		
		Mockito.when(this.drinkService.create(testDrink)).thenReturn(testDrink);
		
		mvc.perform(post("/drink/create")
		.content(testDrinkAsJson)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(content().json(testDrinkAsJson));
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Drink> mockOutput = new ArrayList<Drink>();
		mockOutput.add(new Drink(1L, "Fanta", 1000, true, 333));
		mockOutput.add(new Drink(2L, "Tizer", 1000, true, 333));
		String mockOutputAsJson = this.mapper.writeValueAsString(mockOutput);
		
		Mockito.when(this.drinkService.getAll()).thenReturn(mockOutput);
		
		mvc.perform(get("/drink/getall"))
		.andExpect(status().isOk())
		.andExpect(content().json(mockOutputAsJson));
	}

}
