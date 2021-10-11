package com.murilonerdx.challengebackendhit.config;

import com.murilonerdx.challengebackendhit.service.IPlanetService;
import com.murilonerdx.challengebackendhit.service.PagePlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
@RequiredArgsConstructor
public class DbInitializer {

    @Autowired
    private PagePlanetService service;

    @Autowired
    private IPlanetService planetService;

    @Bean
    public boolean instantiateDatabase() {
        planetService.saveAll(service.getListPlanet());
        return true;
    }
}
