package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Distillery;
import dev.leonhardt.whiskyreview.repository.DistilleryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
