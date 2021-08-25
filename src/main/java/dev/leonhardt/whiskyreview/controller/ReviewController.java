package dev.leonhardt.whiskyreview.controller;

import dev.leonhardt.whiskyreview.model.Review;
import dev.leonhardt.whiskyreview.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/reviews")
public class ReviewController {
    private final ReviewRepository repository;

    ReviewController(ReviewRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Review> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Review one(@PathVariable int id) {
        Optional<Review> review = this.repository.findById(id);
        return review.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
