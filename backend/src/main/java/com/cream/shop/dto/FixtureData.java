package com.cream.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FixtureData {

    private Long id;
    private String name;

    @JsonProperty("starting_at")
    private LocalDateTime startingAt;

    @JsonProperty("home_team")
    private String homeTeam;

    @JsonProperty("away_team")
    private String awayTeam;

    // Getters and Setters
}