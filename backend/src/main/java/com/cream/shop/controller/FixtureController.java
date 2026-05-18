package com.cream.shop.controller;

import org.springframework.web.bind.annotation.*;
import com.cream.shop.service.SportMonksService;
 
@RestController
@RequestMapping("/api/fixtures1")
public class FixtureController {

    private final SportMonksService service;

    public FixtureController(SportMonksService service) {
        this.service = service;
    }

    @PostMapping("/sync")
    public String syncFixtures() {
        service.fetchAndSaveFixtures();
        return "Fixtures synced successfully!";
    }
}