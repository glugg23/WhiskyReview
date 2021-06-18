package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Country;
import dev.leonhardt.whiskyreview.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
    private final CountryRepository repository;

    CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    List<Country> all() {
        return this.repository.findAll();
    }

    @GetMapping("/countries/{id}")
    ResponseEntity<Country> one(@PathVariable int id) {
        Optional<Country> country = this.repository.findById(id);

        return country.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
