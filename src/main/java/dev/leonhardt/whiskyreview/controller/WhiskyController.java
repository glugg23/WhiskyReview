package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Whisky;
import dev.leonhardt.whiskyreview.repository.WhiskyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {
    private final WhiskyRepository repository;

    WhiskyController(WhiskyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/whiskies")
    List<Whisky> all() {
        return repository.findAll();
    }

    @GetMapping("/whiskies/{id}")
    ResponseEntity<Whisky> one(@PathVariable int id) {
        Optional<Whisky> whisky = this.repository.findById(id);

        return whisky.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
