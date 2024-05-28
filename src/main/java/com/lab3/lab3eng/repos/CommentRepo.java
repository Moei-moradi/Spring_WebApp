package com.lab3.lab3eng.repos;

import com.lab3.lab3eng.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment , Integer> {
}
