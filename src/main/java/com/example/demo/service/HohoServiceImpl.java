package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HohoServiceImpl implements HohoService{

    private final StringBuilder stringTemplate = new StringBuilder();
    @Override
    public void printHoho(Character symbol) {
        if (symbol.equals('O') || symbol.equals('H')) {
            stringTemplate.append(symbol);
            System.out.println(stringTemplate);
        }
        else throw new RuntimeException("Ввести можно только H или O");
    }
}
