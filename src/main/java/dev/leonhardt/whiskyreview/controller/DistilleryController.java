package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Distillery;
import dev.leonhardt.whiskyreview.repository.DistilleryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/distilleries")
public class DistilleryController {
    private final DistilleryRepository repository;

    DistilleryController(DistilleryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Distillery> all() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    Distillery one(@PathVariable int id) {
        Optional<Distillery> distillery = this.repository.findById(id);
        return distillery.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Distillery> create(@RequestBody Distillery newDistillery) {
        try {
            Distillery distillery = repository.save(newDistillery);
            return new ResponseEntity<>(distillery, HttpStatus.CREATED);

        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
