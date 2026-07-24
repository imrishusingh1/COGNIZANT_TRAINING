package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        
    }

    public BookService(BookRepository bookRepository) {
        
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Constructor injection used.");
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("[BookService] Setter injection: BookRepository injected.");
    }

    public String findBook(int id) {
        System.out.println("[BookService] findBook() called with id=" + id);
        return bookRepository.findBookById(id);
    }

    public void addBook(String title) {
        System.out.println("[BookService] addBook() called with title=" + title);
        bookRepository.saveBook(title);
    }

    public void listAllBooks() {
        System.out.println("[BookService] listAllBooks() called");
        bookRepository.findAllBooks();
    }
}
