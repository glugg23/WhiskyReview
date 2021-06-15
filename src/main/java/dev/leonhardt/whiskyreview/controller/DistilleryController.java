package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Distillery;
import dev.leonhardt.whiskyreview.repository.DistilleryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {
    private final DistilleryRepository repository;

    DistilleryController(DistilleryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/distilleries")
    List<Distillery> all() {
        return this.repository.findAll();
    }

    @GetMapping("/distilleries/{id}")
    ResponseEntity<Distillery> one(@PathVariable int id) {
        Optional<Distillery> region = this.repository.findById(id);

        return region.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
