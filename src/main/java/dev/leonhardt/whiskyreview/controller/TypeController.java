package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Type;
import dev.leonhardt.whiskyreview.repository.TypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/types")
public class TypeController {
    private final TypeRepository repository;

    TypeController(TypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Type> all() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    Type one(@PathVariable int id) {
        Optional<Type> type = this.repository.findById(id);
        return type.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
