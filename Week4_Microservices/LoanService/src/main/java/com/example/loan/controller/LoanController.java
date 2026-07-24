package com.example.loan.controller;

import com.example.loan.model.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private static final List<Loan> loans = Arrays.asList(
        new Loan(1L, "LOAN-001", "HOME", 500000.0, 8.5, 240, "John Doe"),
        new Loan(2L, "LOAN-002", "CAR", 350000.0, 10.5, 60, "Jane Smith"),
        new Loan(3L, "LOAN-003", "PERSONAL", 100000.0, 12.0, 36, "Bob Johnson")
    );

    @GetMapping
    public List<Loan> getAllLoans() {
        return loans;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Optional<Loan> loan = loans.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
        return loan.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        System.out.println("[LoanService] Creating new loan: " + loan.getLoanNumber());
        return loan;
    }

    @GetMapping("/health")
    public String health() {
        return "Loan Service is running on port 8091";
    }
}
