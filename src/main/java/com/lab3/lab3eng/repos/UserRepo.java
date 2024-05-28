package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
