package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Country;
import dev.leonhardt.whiskyreview.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/countries")
public class CountryController {
    private final CountryRepository repository;

    CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Country> all() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    Country one(@PathVariable int id) {
        Optional<Country> country = this.repository.findById(id);
        return country.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
