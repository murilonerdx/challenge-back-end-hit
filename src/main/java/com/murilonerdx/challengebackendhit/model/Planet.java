package com.murilonerdx.challengebackendhit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.murilonerdx.challengebackendhit.model.response.PlanetResponseDTO;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Planet implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="Name is required")
    private String name;

    private String rotationPeriod;

    private String orbitalPeriod;

    private String diameter;

    @NotEmpty(message="Climate is required. Ex: arid, temperate, tropical, frozen, murky")
    private String climate;

    private String gravity;

    @NotEmpty(message="Terrain is required. Ex: desert, grasslands, mountains, jungle, rainforests, tundra, ice caves, mountain ranges, swamp")
    private String terrain;

    private String surfaceWater;

    private String population;

    private String created;

    private String edited;

    private String url;

    public Planet(PlanetResponseDTO dto){
        this.name=dto.getName();
        this.rotationPeriod=dto.getRotation_period();
        this.orbitalPeriod= dto.getOrbital_period();
        this.diameter=dto.getDiameter();
        this.climate=dto.getClimate();
        this.gravity=dto.getGravity();
        this.terrain=dto.getTerrain();
        this.surfaceWater=dto.getSurface_water();
        this.population=dto.getPopulation();
        this.created= dto.getCreated();
        this.edited=dto.getEdited();
        this.url=dto.getUrl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Planet planet = (Planet) o;

        return Objects.equals(id, planet.id);
    }

    @Override
    public int hashCode() {
        return 1152863472;
    }
}
