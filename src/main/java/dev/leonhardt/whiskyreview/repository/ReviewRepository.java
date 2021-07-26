package dev.leonhardt.whiskyreview.repository;

import dev.leonhardt.whiskyreview.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
