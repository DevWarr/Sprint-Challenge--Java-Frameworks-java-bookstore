package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthorController
{
    @Autowired
    AuthorService authorService;

    // http://localhost:2019/authors?sort=lastname
    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> findAllAuthors(@PageableDefault(size = 5) Pageable pageable)
    {
        return new ResponseEntity<>(authorService.findAll(pageable), HttpStatus.OK);
    }
}
