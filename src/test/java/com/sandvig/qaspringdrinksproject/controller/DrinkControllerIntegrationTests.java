package com.sandvig.qaspringdrinksproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandvig.qaspringdrinksproject.domain.Drink;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:drink-schema.sql", "classpath:drink-data.sql"},
								executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class DrinkControllerIntegrationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void testCreate() throws Exception {
		Drink testDrink = new Drink("Fanta", 2000, true, 333);
		Drink expectedDrink = new Drink(3L, "Fanta", 2000, true, 333);
		
		String testDrinkAsJson = mapper.writeValueAsString(testDrink);
		String expectedDrinkAsJson = mapper.writeValueAsString(expectedDrink);
		
		mvc.perform(post("/drink/create")
		.content(testDrinkAsJson)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(content().json(expectedDrinkAsJson));
	}
	
	@Test
	public void testGetAll() throws Exception {
		List<Drink> expectedList = new ArrayList<Drink>();
		expectedList.add(new Drink(1L, "DnB", 2000, true, 333));
		expectedList.add(new Drink(2L, "Root Beer", 1000, true, 332));
		
		String expectedListAsJson = mapper.writeValueAsString(expectedList);
		
		mvc.perform(get("/drink/getall"))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedListAsJson));
	}
	
	@Test
	public void testGetById() throws Exception {
		Drink expectedDrink = new Drink(2L, "Root Beer", 1000, true, 332);
		
		String expectedDrinkAsJson = mapper.writeValueAsString(expectedDrink);
		
		mvc.perform(get("/drink/getbyid/2"))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedDrinkAsJson));
	}
	
	@Test
	public void testGetByName() throws Exception {
		Drink expectedDrink = new Drink(2L, "Root Beer", 1000, true, 332);
		
		String expectedDrinkAsJson = mapper.writeValueAsString(expectedDrink);
		
		mvc.perform(get("/drink/getbyname/Root Beer"))
		.andExpect(status().isOk())
		.andExpect(content().json(expectedDrinkAsJson));
	}
	
	@Test
	public void testUpdate() throws Exception {
		Drink testDrink = new Drink("DnB", 1000, true, 332);
		Drink expectedDrink = new Drink(1L, "DnB", 1000, true, 332);
		
		String testDrinkAsJson = mapper.writeValueAsString(testDrink);
		String expectedDrinkAsJson = mapper.writeValueAsString(expectedDrink);
		
		mvc.perform(put("/drink/update/1")
		.content(testDrinkAsJson)
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isAccepted())
		.andExpect(content().json(expectedDrinkAsJson));
	}
	
	@Test
	public void testDelete() throws Exception {
		mvc.perform(delete("/drink/delete/1"))
		.andExpect(status().isNoContent());
	}
}
