package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController
{
    @Autowired
    BookService bookService;

    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> findAllBooks()
    {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }
}
