package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController
{
    @Autowired
    AuthorService authorService;

    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> findAllAuthors()
    {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
}
