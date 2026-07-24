package com.example.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GreetingServiceTest {

    private MessageSender messageSender;
    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        messageSender = Mockito.mock(MessageSender.class);
        greetingService = new GreetingService(messageSender);
    }

    @AfterEach
    void tearDown() {
        messageSender = null;
        greetingService = null;
    }

    @Test
    void shouldReturnGreetingAndSendMessage() {
        String result = greetingService.greet("Alice");

        assertEquals("Hello, Alice!", result);
        verify(messageSender).send("Hello, Alice!");
    }

    @Test
    void shouldThrowExceptionForBlankName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> greetingService.greet("   "));

        assertEquals("Name cannot be blank", exception.getMessage());
        verify(messageSender, never()).send(anyString());
    }
}
