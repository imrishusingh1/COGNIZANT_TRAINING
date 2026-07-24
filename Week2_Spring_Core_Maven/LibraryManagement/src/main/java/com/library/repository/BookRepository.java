package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    public String findBookById(int id) {
        System.out.println("[BookRepository] Fetching book with ID: " + id);
        return "Book #" + id + ": Spring in Action";
    }

    public void saveBook(String title) {
        System.out.println("[BookRepository] Saving book: " + title);
    }

    public void findAllBooks() {
        System.out.println("[BookRepository] Fetching all books...");
        System.out.println("  - Spring in Action");
        System.out.println("  - Effective Java");
        System.out.println("  - Clean Code");
    }
}
