package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Toys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToysRepo extends JpaRepository<Toys, Integer> {
}
