package com.example.service;

public class GreetingService {
    private final MessageSender messageSender;

    public GreetingService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public String greet(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        String message = "Hello, " + name + "!";
        messageSender.send(message);
        return message;
    }
}
