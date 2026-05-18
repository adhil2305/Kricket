package com.cream.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "fixtures")
@Getter
@Setter
public class Fixture {

    @Id
    private Long id;

    private String name;

    private String homeTeam;

    private String awayTeam;

    private LocalDateTime startingAt;

    // Getters and Setters
}