package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
