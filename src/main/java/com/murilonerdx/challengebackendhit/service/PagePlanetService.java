package com.murilonerdx.challengebackendhit.service;

import com.murilonerdx.challengebackendhit.model.Planet;
import com.murilonerdx.challengebackendhit.model.response.PlanetResponseDTO;
import com.murilonerdx.challengebackendhit.model.response.PagePlanetJsonRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagePlanetService {

    final String URL_PATH_PLANETS = "https://swapi.dev/api/planets/?format=json";

    public List<PagePlanetJsonRequest> getPageList(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate template = builder.build();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        List<PagePlanetJsonRequest> planets =
                Collections.singletonList(template.exchange(URL_PATH_PLANETS, HttpMethod.GET, entity, PagePlanetJsonRequest.class).getBody());

        return planets;
    }

    public List<PlanetResponseDTO> getPlanetsDTORaw(){
        List<PlanetResponseDTO> planetsRaw = new ArrayList<>();

        for(PagePlanetJsonRequest a : getPageList()){
            planetsRaw.addAll(a.getResults());
        }

        return planetsRaw;
    }

    public List<Planet> getListPlanet(){
        return getPlanetsDTORaw().stream().map(Planet::new).collect(Collectors.toList());
    }


}
