package com.murilonerdx.challengebackendhit.service;

import com.murilonerdx.challengebackendhit.model.Planet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IPlanetService {
    Planet create(Planet planet);
    void saveAll(List<Planet> planets);
    List<Planet> getAll();
    Planet findByName(String name);
    Optional<Planet> findById(Long id);
    void delete(Long id);
}
