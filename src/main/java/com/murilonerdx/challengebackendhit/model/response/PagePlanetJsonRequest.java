package com.murilonerdx.challengebackendhit.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagePlanetJsonRequest {
    private Integer count;
    private String next;
    private String previous;
    private List<PlanetResponseDTO> results;
}
