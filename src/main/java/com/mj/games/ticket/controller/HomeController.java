package com.mj.games.ticket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
    @GetMapping("/")
    public String welcome(){
        return "Welcome to Games Online Ticket module";
    }
}
