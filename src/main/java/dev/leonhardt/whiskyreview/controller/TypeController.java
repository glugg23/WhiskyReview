package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Type;
import dev.leonhardt.whiskyreview.repository.TypeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TypeController {
    private final TypeRepository repository;

    TypeController(TypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/types")
    List<Type> all() {
        return this.repository.findAll();
    }

    @GetMapping("/types/{id}")
    ResponseEntity<Type> one(@PathVariable int id) {
        Optional<Type> type = this.repository.findById(id);

        return type.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
