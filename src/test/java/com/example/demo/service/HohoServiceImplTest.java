package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HohoServiceImplTest {

    private HohoServiceImpl hohoService;

    @BeforeEach
    void setUp() {
        hohoService = new HohoServiceImpl();
    }

    @Test
    void whenSymbolIsHOrO_thenSuccess() {
        assertDoesNotThrow(() -> hohoService.printHoho('H'));
        assertDoesNotThrow(() -> hohoService.printHoho('O'));
    }

    @Test
    void whenSymbolIsNotHOrO_thenThrowException() {
        Exception exception = assertThrows(RuntimeException.class, () -> hohoService.printHoho('A'));
        assertTrue(exception.getMessage().contains("Ввести можно только H или O"));
    }
}
