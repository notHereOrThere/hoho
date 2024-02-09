package com.example.demo.controller;

import com.example.demo.service.HohoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HohoController {

    private final HohoService hohoService;

    public HohoController(HohoService hohoService) {
        this.hohoService = hohoService;
    }

    @PostMapping("print-hoho")
    public Map<String, String> printHoho(@RequestBody Character symbol) {

        try {
            hohoService.printHoho(symbol);
            Map<String, String> map = new HashMap<>();
            map.put("STATUS", "SUCCESS");
            return map;
        } catch (Exception e) {
            Map<String, String> map = new HashMap<>();
            map.put("STATUS", "FAILURE: " + e.getMessage());
            return map;
        }
    }
}
