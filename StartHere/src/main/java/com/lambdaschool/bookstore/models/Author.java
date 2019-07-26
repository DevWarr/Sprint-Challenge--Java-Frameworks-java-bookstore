package com.lambdaschool.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends Auditable
{
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @Column(nullable = false)
    private String lastname;

    private String firstname;

    @OneToMany(mappedBy = "author",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("author")
    private List<BookAuthors> bookAuthors = new ArrayList<>();

    // Constructors

    public Author()
    {}

    public Author(String lastname, String firstname, List<BookAuthors> bookAuthors) {
        this.lastname = lastname;
        this.firstname = firstname;
        for(BookAuthors ba : bookAuthors)
        {
            ba.setAuthor(this);
        }
        this.bookAuthors = bookAuthors;
    }

    // Getters and Setters

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<BookAuthors> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<BookAuthors> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
