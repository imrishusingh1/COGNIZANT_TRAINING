package com.example.account.controller;

import com.example.account.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static List<Account> accounts = Arrays.asList(
        new Account(1L, "ACC-001", "SAVINGS", 50000.0, "John Doe"),
        new Account(2L, "ACC-002", "CURRENT", 150000.0, "Jane Smith"),
        new Account(3L, "ACC-003", "SAVINGS", 25000.0, "Bob Johnson")
    );

    @GetMapping
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
        return account.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        System.out.println("[AccountService] Creating new account: " + account);
        return account;
    }

    @GetMapping("/health")
    public String health() {
        return "Account Service is running on port 8090";
    }
}
