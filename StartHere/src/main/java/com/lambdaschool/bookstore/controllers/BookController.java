package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    BookService bookService;

    // http://localhost:2019/authors?page=1&size=2
    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> findAllBooks(@PageableDefault(size = 5) Pageable pageable, HttpServletRequest request)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        return new ResponseEntity<>(bookService.findAll(pageable), HttpStatus.OK);
    }
}
