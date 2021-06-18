package dev.leonhardt.whiskyreview.repository;

import dev.leonhardt.whiskyreview.model.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhiskyRepository extends JpaRepository<Whisky, Integer> {
}
