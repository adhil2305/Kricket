package com.cream.shop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cream.shop.service.SportMonksService;

@RestController
@CrossOrigin
@RequestMapping("/japanese/sportmonks")
public class SportMonksController {

    private final SportMonksService service;

    public SportMonksController(SportMonksService service) {
        this.service = service;
    }

    @PostMapping("/syncro")
    public String syncFixtures() {
        service.fetchAndSaveFixtures();
        return "Fixtures saved to DB";
    }
}
