package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book extends Auditable
{
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid; // Book id for database

    @Column(nullable = false)
    private String booktitle; // Book title

    @Column(unique = true, nullable = false)
    private String ISBN; // ISBN number

    private Integer copy; // Copyright year

    @OneToMany(mappedBy = "book",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<BookAuthors> bookAuthors = new ArrayList<>();

    //Constructor

    public Book()
    {}

    public Book(String booktitle, String ISBN, List<BookAuthors> bookAuthors) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        for(BookAuthors ba : bookAuthors)
        {
            ba.setBook(this);
        }
        this.bookAuthors = bookAuthors;
    }

    public Book(String booktitle, String ISBN, int copy, List<BookAuthors> bookAuthors) {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        for(BookAuthors ba : bookAuthors)
        {
            ba.setBook(this);
        }
        this.bookAuthors = bookAuthors;
    }

    // Getters and Setters


    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public List<BookAuthors> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<BookAuthors> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
