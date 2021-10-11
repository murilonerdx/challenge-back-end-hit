package com.murilonerdx.challengebackendhit.service.impl;

import com.murilonerdx.challengebackendhit.model.Planet;
import com.murilonerdx.challengebackendhit.repository.PlanetRepository;
import com.murilonerdx.challengebackendhit.service.IPlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetImpl implements IPlanetService {

    @Autowired
    private PlanetRepository repository;

    @Override
    public Planet create(Planet planet) {
        return repository.save(planet);
    }

    @Override
    public void saveAll(List<Planet> planets) {
        repository.saveAll(planets);
    }

    @Override
    public List<Planet> getAll() {
        return repository.findAll();
    }

    @Override
    public Planet findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    @Override
    public Optional<Planet> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
