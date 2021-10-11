package com.murilonerdx.challengebackendhit.controller;

import com.murilonerdx.challengebackendhit.exception.NotFoundPlanet;
import com.murilonerdx.challengebackendhit.model.Planet;
import com.murilonerdx.challengebackendhit.service.IPlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value={"/challenge-backend-hit", "/"})
public class ChallengeBackendHitController {

    @Autowired
    private IPlanetService service;

    @GetMapping
    public ResponseEntity<List<Planet>> getAllPlanets(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping()
    public ResponseEntity<Planet> createPlanet(
            @RequestBody @Valid Planet planet,
            UriComponentsBuilder uriBuilder
    ){
        String dateCreate = String.valueOf(LocalDateTime.now());

        planet.setCreated(dateCreate);
        planet.setEdited(dateCreate);

        Planet savePlanet = service.create(planet);
        URI uri = uriBuilder
                .path("/challenge-backend-hit/{id}")
                .buildAndExpand(savePlanet.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savePlanet);
    }

    @GetMapping("/planet")
    public ResponseEntity<Planet> findByName(@RequestParam("name") String namePlanet){
        Planet planet = service.findByName(namePlanet);
        if(planet == null) throw new NotFoundPlanet("Planet not found");
        return ResponseEntity.ok().body(planet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id){
        Planet planet = service.findById(id).orElse(null);
        if(planet == null) throw new NotFoundPlanet("Planet id "+id+" not found");
        return ResponseEntity.ok().body(planet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            service.delete(id);
        }catch(RuntimeException e){
            throw new NotFoundPlanet("Planet id "+id+" not found");
        }
        return ResponseEntity.noContent().build();
    }

}
