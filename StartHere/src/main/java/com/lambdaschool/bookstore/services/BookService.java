package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;

import java.util.List;

public interface BookService
{
    List<Book> findAll();

    Book updateInfo(Book book);

    Book saveAuthor(long bookid, long authorid);

    void delete(long id);
}
