package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<Food, Integer> {
}
