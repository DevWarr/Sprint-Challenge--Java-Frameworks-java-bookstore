package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController
{
    @Autowired
    BookService bookService;

    // http://localhost:2019/authors?page=1&size=2
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> findAllBooks(@PageableDefault(size = 5) Pageable pageable)
    {
        return new ResponseEntity<>(bookService.findAll(pageable), HttpStatus.OK);
    }
}
