package com.example.demo.controller;

import com.example.demo.service.HohoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HohoController.class)
public class HohoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HohoService hohoService;

    @Test
    public void whenPrintHohoWithValidSymbol_thenReturnSuccess() throws Exception {
        char symbol = 'O';
        doNothing().when(hohoService).printHoho(symbol);

        mockMvc.perform(post("/print-hoho")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"O\""))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"STATUS\":\"SUCCESS\"}"));
    }

    @Test
    public void whenPrintHohoThrowsException_thenReturnFailure() throws Exception {
        char symbol = 'A';
        doThrow(new RuntimeException("Error occurred")).when(hohoService).printHoho(symbol);

        mockMvc.perform(post("/print-hoho")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("\"A\""))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"STATUS\":\"FAILURE: Error occurred\"}"));
    }
}
