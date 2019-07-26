package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookrepo;

    @Override
    public List<Book> findAll()
    {
        List<Book> books = new ArrayList<>();
        bookrepo.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public Book updateInfo(Book book) {
        return null;
    }

    @Override
    public Book saveAuthor(long bookid, long authorid) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
