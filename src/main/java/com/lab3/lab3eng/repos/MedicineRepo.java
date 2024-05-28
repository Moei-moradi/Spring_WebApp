package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Integer> {
}
