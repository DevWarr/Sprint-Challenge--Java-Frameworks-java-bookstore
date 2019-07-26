package com.lambdaschool.bookstore;

import com.lambdaschool.bookstore.models.*;
import com.lambdaschool.bookstore.services.RoleService;
import com.lambdaschool.bookstore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;




    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
        roleService.save(r3);

        // admin, data, user
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        userService.save(u1);

        // data, user
        ArrayList<UserRoles> datas = new ArrayList<>();
        datas.add(new UserRoles(new User(), r3));
        datas.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", datas);
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);

        // Authors
        Author a1 = new Author("Mitchell", "John");
        Author a2 = new Author("Brown", "Dan");
        Author a3 = new Author("Poe", "Jerry");
        Author a4 = new Author("Teague", "Wells");
        Author a5 = new Author("Gallinger", "George");
        Author a6 = new Author("Stewart", "Ian");

        // Books
        ArrayList<BookAuthors> wrote = new ArrayList<>();
        wrote.add(new BookAuthors(new Book(), a6));
        Book book3 = new Book("Flatterland", "9780738206752", 2001, wrote);

        wrote = new ArrayList<>();
        wrote.add(new BookAuthors(new Book(), a2));
        Book book1 = new Book("Digital Fortess", "9788489367012", 2007, wrote);

        wrote = new ArrayList<>();
        wrote.add(new BookAuthors(new Book(), a2));
        Book book2 = new Book("The Da Vinci Code", "9780307474278", 2009, wrote);

        wrote = new ArrayList<>();
        wrote.add(new BookAuthors(new Book(), a3));
        wrote.add(new BookAuthors(new Book(), a5));
        Book book4 = new Book("Essentials of Finance", "1314241651234", wrote);

        wrote = new ArrayList<>();
        wrote.add(new BookAuthors(new Book(), a4));
        Book book5 = new Book("Calling Texas Home", "1885171382134", 2000, wrote);
    }
}