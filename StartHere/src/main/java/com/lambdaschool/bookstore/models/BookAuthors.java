package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bookauthors")
public class BookAuthors extends Auditable implements Serializable
{
    // Fields
    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    @JsonIgnoreProperties("bookAuthors")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties("bookAuthors")
    private Author author;

    // Constructor

    public BookAuthors()
    {}

    public BookAuthors(Book book, Author author) {
        this.book = book;
        this.author = author;
    }

    // Getters and Setters

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof BookAuthors))
        {
            return false;
        }
        BookAuthors userRoles = (BookAuthors) o;
        return getBook().equals(userRoles.getBook()) && getAuthor().equals(userRoles.getAuthor());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getBook(), getAuthor());
    }
}
