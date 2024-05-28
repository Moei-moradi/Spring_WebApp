package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {
}
