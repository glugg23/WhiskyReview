package dev.leonhardt.whiskyreview.repository;

import dev.leonhardt.whiskyreview.model.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistilleryRepository extends JpaRepository<Distillery, Integer> {
}
