package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
