package com.sandvig.qaspringdrinksproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandvig.qaspringdrinksproject.domain.Drink;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Long>{

}
