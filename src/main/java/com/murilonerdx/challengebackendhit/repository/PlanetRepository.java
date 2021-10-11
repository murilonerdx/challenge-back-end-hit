package com.murilonerdx.challengebackendhit.repository;

import com.murilonerdx.challengebackendhit.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Optional<Planet> findByName(String name);
}
