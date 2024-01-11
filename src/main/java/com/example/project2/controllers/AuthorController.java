package com.example.project2.controllers;
import com.example.project2.entities.AuthorEntity;
import com.example.project2.models.Author;
import com.example.project2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/authors")
@CrossOrigin
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorServiceImpl) {
        this.authorService = authorServiceImpl;
    }

    @PostMapping("/create")
    public Author createNewAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @GetMapping("/allAuthors")
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("lastName/{lastName}")
    public Author getAuthorByLastName(@PathVariable String lastName) {
        return authorService.getAuthorByLastName(lastName);
    }

    @PutMapping("/{id}")
    public Author updateAuthorDetails(@PathVariable Integer id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthorsById(@PathVariable Integer id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteAllAuthors() {
        authorService.deleteAllAuthors();
        return ResponseEntity.ok().build();
    }
}
