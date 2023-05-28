package com.mj.games.ticket.controller;

import com.mj.games.ticket.entity.ThemeParkRide;
import com.mj.games.ticket.repository.ThemeParkRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ThemeParkRideController {
    @Autowired
   ThemeParkRideRepository themeParkRideRepository;

   @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide getRide(@PathVariable long id) throws Throwable {
        return (ThemeParkRide) themeParkRideRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ThemeParkRide createRide(@Validated @RequestBody ThemeParkRide themeParkRide) {
        return (ThemeParkRide) themeParkRideRepository.save(themeParkRide);
    }
}
