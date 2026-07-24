package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("=== Library Management System - Spring Core Demo ===");
        System.out.println();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println();
        System.out.println("--- Spring context loaded successfully ---");
        System.out.println();

        BookService bookService = (BookService) context.getBean("bookService");

        System.out.println();
        System.out.println("=== Testing BookService Operations ===");

        System.out.println("\n[Test 1] Finding book by ID:");
        String book = bookService.findBook(1);
        System.out.println("  Result: " + book);

        System.out.println("\n[Test 2] Adding a new book:");
        bookService.addBook("Design Patterns: Elements of Reusable Object-Oriented Software");

        System.out.println("\n[Test 3] Listing all books:");
        bookService.listAllBooks();

        System.out.println();
        System.out.println("=== Exercise 7: Constructor Injection Test ===");

        BookService constructorInjectedService = (BookService) context.getBean("bookServiceConstructor");
        constructorInjectedService.findBook(42);

        System.out.println();
        System.out.println("=== Library Management Application completed successfully ===");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
