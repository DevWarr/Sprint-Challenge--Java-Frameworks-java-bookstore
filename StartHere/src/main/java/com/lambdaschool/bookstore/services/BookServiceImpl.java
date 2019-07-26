package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookrepo;

    @Override
    public List<Book> findAll(Pageable pageable)
    {
        List<Book> books = new ArrayList<>();
        bookrepo.findAll(pageable).iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public Book updateInfo(Book book, long id) throws ResourceNotFoundException
    {
        Book updateBook = bookrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));

        if (book.getBooktitle() != null)
        {
            updateBook.setBooktitle(book.getBooktitle());
        }
        if (book.getISBN() != null)
        {
            updateBook.setISBN(book.getISBN());
        }
        if (book.getCopy() != null)
        {
            updateBook.setCopy(book.getCopy());
        }
        return bookrepo.save(updateBook);
    }

    @Override
    public void saveAuthor(long bookid, long authorid)
    {
        bookrepo.insertBookAuthors(bookid, authorid);
    }

    @Override
    public void delete(long id) {

    }
}
