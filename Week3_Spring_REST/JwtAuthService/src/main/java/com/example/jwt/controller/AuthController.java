package com.example.jwt.controller;

import com.example.jwt.model.JwtResponse;
import com.example.jwt.model.LoginRequest;
import com.example.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        if (isValidUser(loginRequest.getUsername(), loginRequest.getPassword())) {
            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new JwtResponse(token, loginRequest.getUsername()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials. Please check username and password.");
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        if (jwtUtil.validateToken(token)) {
            String username = jwtUtil.getUsernameFromToken(token);
            return ResponseEntity.ok("Token is valid. Username: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Token is invalid or expired.");
        }
    }

    private boolean isValidUser(String username, String password) {
        
        return ("admin".equals(username) && "password".equals(password))
                || ("user".equals(username) && "user123".equals(password))
                || ("cognizant".equals(username) && "cognizant123".equals(password));
    }
}
