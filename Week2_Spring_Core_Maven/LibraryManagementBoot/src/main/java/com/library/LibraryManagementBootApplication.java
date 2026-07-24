package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementBootApplication implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== Seeding Library Database ===");

        bookRepository.save(new Book("Spring in Action", "Craig Walls", "978-1617294945"));
        bookRepository.save(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));
        bookRepository.save(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
        bookRepository.save(new Book("Design Patterns", "Gang of Four", "978-0201633610"));

        System.out.println("=== Seeded " + bookRepository.count() + " books ===");
        System.out.println("REST API available at: http://localhost:8080/api/books");
        System.out.println("H2 Console available at: http://localhost:8080/h2-console");
    }
}
