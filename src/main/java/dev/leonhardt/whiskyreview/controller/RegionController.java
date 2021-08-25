package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Region;
import dev.leonhardt.whiskyreview.repository.RegionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/regions")
public class RegionController {
    private final RegionRepository repository;

    RegionController(RegionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Region> all() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    Region one(@PathVariable int id) {
        Optional<Region> region = this.repository.findById(id);
        return region.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
