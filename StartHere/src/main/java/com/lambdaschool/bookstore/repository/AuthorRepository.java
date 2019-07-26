package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.models.Author;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AuthorRepository extends CrudRepository<Author, Long>
{
    @Transactional
    @Modifying
    @Query(value = "DELETE from BookAuthors where bookid = :bookid")
    void deleteBookAuthorsbyBookId(long bookid);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO BookAuthors(bookid, authorid) values (:bookid, :authorid)",
            nativeQuery = true)
    void insertBookAuthors(long bookid, long authorid);
}
