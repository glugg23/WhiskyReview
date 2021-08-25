package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Whisky;
import dev.leonhardt.whiskyreview.repository.WhiskyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/whiskies")
public class WhiskyController {
    private final WhiskyRepository repository;

    WhiskyController(WhiskyRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Whisky> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Whisky one(@PathVariable int id) {
        Optional<Whisky> whisky = this.repository.findById(id);
        return whisky.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
