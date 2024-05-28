package com.lab3.lab3eng.controllers;

import com.lab3.lab3eng.model.Comment;
import com.lab3.lab3eng.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentRepo commentRepo;

    @GetMapping("/comments")
    public Iterable<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepo.save(comment);
    }

    @PutMapping("/comments/{id}")
    public Comment updateComment(@PathVariable int id, @RequestBody Comment updatedComment) {
        if (commentRepo.existsById(id)) {
            updatedComment.setId(id);
            return commentRepo.save(updatedComment);
        }
        return null; // Handle not found scenario
    }

    @DeleteMapping("/comments/{id}")
    public Optional<Comment> deleteComment(@PathVariable int id) {
        Optional<Comment> comment = commentRepo.findById(id);
        comment.ifPresent(value -> commentRepo.delete(value));
        return comment;
    }
}
