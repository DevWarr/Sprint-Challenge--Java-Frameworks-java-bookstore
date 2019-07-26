package com.lambdaschool.bookstore.controllers;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.models.ErrorDetail;
import com.lambdaschool.bookstore.services.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/data")
public class DataController
{
    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    BookService bookService;

    @ApiOperation(value = "Updates A book with the given request body.", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Updated.", response = void.class),
            @ApiResponse(code = 500, message = "Error updating book.", response = ErrorDetail.class)})
    @PutMapping(value = "/books/{id}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateBook(@RequestBody Book book,
                                        @ApiParam(name = "Book Id", required = true)
                                            @PathVariable long id,
                                        HttpServletRequest request)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        bookService.updateInfo(book, id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @ApiOperation(value = "Assigns a specic Author to a specific Book.", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Book-Author relationship Created Successfully.", response = void.class),
            @ApiResponse(code = 500, message = "Error linking book and author.", response = ErrorDetail.class)})
    @PostMapping(value = "/books/{bookid}/authors/{authorid}")
    public ResponseEntity<?> updateBookAuthor(@ApiParam(name = "Book Id", required = true)
                                                  @PathVariable long bookid,
                                              @ApiParam(name = "Author Id", required = true)
                                              @PathVariable long authorid,
                                              HttpServletRequest request)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        bookService.saveAuthor(bookid, authorid);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Deletes a book with the id given.", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book deleted successfully. Any links to an author have also been removed.", response = void.class),
            @ApiResponse(code = 500, message = "Error deleting book and/or error deleting book-author relationship.", response = ErrorDetail.class)})
    @DeleteMapping(value = "books/{id}")
    public ResponseEntity<?> deleteBook(@ApiParam(name = "Book Id", required = true)
                                            @PathVariable long id,
                                        HttpServletRequest request)
    {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed");

        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
