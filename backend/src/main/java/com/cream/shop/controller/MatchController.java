package com.cream.shop.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cream.shop.service.SportMonksService;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RestController
@RequestMapping("/api/matches")
@CrossOrigin(origins = "http://localhost:3000")
public class MatchController {

	@Value("${sportmonks.api.token}")
	private String token;

	private final RestTemplate restTemplate = new RestTemplate();

	private static final String BASE_URL = "https://cricket.sportmonks.com/api/v2.0";

	@GetMapping("/upcoming")
	public ResponseEntity<?> getUpcomingMatches() {

		String url = UriComponentsBuilder
				.fromHttpUrl(BASE_URL + "/fixtures")
				.queryParam("api_token", token)
				.queryParam("include", "localteam,visitorteam")
				// ,tosswonteam,season,venue")==
				.queryParam("sort", "starting_at")
				.queryParam("per_page", 5)
				.toUriString();

		try {
			Map<String, Object> response = restTemplate.getForObject(url, Map.class);

			if (response == null || !response.containsKey("data")) {
				return ResponseEntity
						.status(HttpStatus.BAD_GATEWAY)
						.body(Map.of("error", "Invalid response from SportMonks Cricket API"));
			}

			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			return ResponseEntity
					.status(HttpStatus.BAD_GATEWAY)
					.body(Map.of("error", "SportMonks Cricket API call failed"));
		}
	}
}
