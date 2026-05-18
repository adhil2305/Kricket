package com.cream.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.cream.shop.dto.FixtureData;
import com.cream.shop.dto.FixtureResponse;
import com.cream.shop.entity.Fixture;
import com.cream.shop.repository.FixtureRepository;

@Service
public class SportMonksService {

    private final WebClient webClient;
    private final FixtureRepository fixtureRepository;

    @Value("${sportmonks.api.token}")
    private String apiToken;

    @Value("${sportmonks.base.url}")
    private String baseUrl;

    public SportMonksService(WebClient webClient,
            FixtureRepository fixtureRepository) {
        this.webClient = webClient;
        this.fixtureRepository = fixtureRepository;
    }

    public void fetchAndSaveFixtures() {

        System.out.println("Fetching fixtures...");

        FixtureResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/fixtures")
                        .queryParam("api_token", apiToken)
                        .build())
                .retrieve()
                .bodyToMono(FixtureResponse.class)
                .block();

        System.out.println("API call completed. Processing response...");

        if (response == null || response.getData() == null) {
            System.out.println("No data received.");
            return;
        }

        List<Fixture> fixtures = response.getData().stream()
                .map(this::convertToEntity)
                .toList();

        fixtureRepository.saveAll(fixtures);

        System.out.println("Saved " + fixtures.size() + " fixtures to DB.");
    }

    private Fixture convertToEntity(FixtureData dto) {
        Fixture fixture = new Fixture();
        fixture.setId(dto.getId());
        fixture.setName(dto.getName());
        fixture.setStartingAt(dto.getStartingAt());
        fixture.setHomeTeam(dto.getHomeTeam());
        fixture.setAwayTeam(dto.getAwayTeam());
        return fixture;
    }
}