package com.sandvig.qaspringdrinksproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandvig.qaspringdrinksproject.domain.Drink;
import com.sandvig.qaspringdrinksproject.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {
	
	private DrinkService drinkService;
	
	public DrinkController(DrinkService drinkService) {
		this.drinkService = drinkService;
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
		return new ResponseEntity<Drink>(this.drinkService.create(drink), 
														HttpStatus.CREATED);
	}
	
	//Read All
	@GetMapping("/getall")
	public ResponseEntity<List<Drink>> getAllDrinks() {
		return new ResponseEntity<List<Drink>>(this.drinkService.getAll(),
														HttpStatus.OK);
	}
	
	//Read By Id
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Drink> getDrinkById(@PathVariable long id) {
		return new ResponseEntity<Drink>(this.drinkService.getByID(id),
														HttpStatus.OK);
	}
	
	//Read By Name
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<Drink> getDrinkByName(@PathVariable String name) {
		return new ResponseEntity<Drink>(this.drinkService.getByName(name),
														HttpStatus.OK);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Drink> updateDrink(@PathVariable long id, 
												@RequestBody Drink drink) {
		return new ResponseEntity<Drink>(this.drinkService.update(id, drink),
														HttpStatus.ACCEPTED);
	}
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteDrink(@PathVariable long id) {
		//Returns true & no content if successful, false & not found if nothing
		//by that id in the database
		return (this.drinkService.delete(id)) ?
				new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}
