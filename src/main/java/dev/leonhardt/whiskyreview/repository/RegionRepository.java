package dev.leonhardt.whiskyreview.repository;

import dev.leonhardt.whiskyreview.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Integer> {
}
