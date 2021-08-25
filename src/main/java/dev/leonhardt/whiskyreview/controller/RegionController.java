package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Region;
import dev.leonhardt.whiskyreview.repository.RegionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegionController {
    private final RegionRepository repository;

    RegionController(RegionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/regions")
    List<Region> all() {
        return this.repository.findAll();
    }

    //TODO: Look into returning an error JSON value on failure
    @GetMapping("/regions/{id}")
    ResponseEntity<Region> one(@PathVariable int id) {
        Optional<Region> region = this.repository.findById(id);

        return region.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
