# java-bookstore

## Introduction

This is a bookstore with books who have authors and can be found in a section of the store.

## Instructions

The provided initial application has the basics in place for
* User Oauth2 Authentication
* Exception Handling
* Swagger
* Logging 
* Unit / Integration testing (at least the POM file entries)
* Deployment to Heroku
* Conversion to Postgresql

Starting with this initial application: https://github.com/LambdaSchool/java-starthere.git 

Create a REST API server to store and read data from a PostgreSQL Database. The table layouts should be

* [x] book
  * [x] bookid - long primary key
  * [x] booktitle - String the title of the book
  * [x] ISBN - String the ISBN number of the book
  * [x] copy - Int the year the book was published (copyright date)
  
* [x] authors
  * [x] authorid - long primary key
  * [x] lastname - String last name of the author
  * vfirstname - String first name of the author

There is a many to many relationship between authors and books. A book may have many authors while an author may write many books.

* [x] Add audit fields to both tables.

* [x] data.sql data moved to SeedData.java.

* [x] Your bookstore endpoints should have customized Swagger documentation. 

* [x] Appropriate Exception handling should be in place for each bookstore endpoint

* [x] The bookstore endpoints should be pageable and sortable.

* [x] List the data

  * [x] GET /books - returns a JSON object list of all the books and their authors.
  
  * [x] GET /authors - returns a JSON object list of all the authors and their books.

* [x] Manage the data

  * [x] PUT /data/books/{id} - updates a books info (Title, Copyright, ISBN) but does NOT have to assign authors to the books.

  * [x] POST /data/books/{bookid}/authors/{authorid} - assigns a book already in the system (bookid) to an author already in the system (authorid) (see how roles are handled for users)

  * [x] DELETE /data/books/{id} - deletes a book and the book author combinations - but does not delete the author records.
 
Your system will have authentication in place. The following are the roles you need to handle:

* [x] User - people who can look up books, authors

* [x] Data - people who can update data on books, authors, sections. The can also read books, authors, sections.

* [x] ADMIN - people who can update data on users and otherwise have full access to the system.

* [x] Make sure that actuator endpoints are exposed

### Deploy the system to Heroku!
* Heroku Deployment success.
Note that several obvious end points are not included in the required list. Finishing out the list of useful end points is the stretch goal. You are to decide what those end points are!
