package com.cream.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "matches")  // or "cricket_match"
public class Match {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String teamA;
	    private String teamB;
	    private String venue;
	    private String status; // Live, Upcoming, Completed
	    private String scoreA;
	    private String scoreB;

	    public Match() {}

	    public Match(String teamA, String teamB, String venue, String status, String scoreA, String scoreB) {
	        this.teamA = teamA;
	        this.teamB = teamB;
	        this.venue = venue;
	        this.status = status;
	        this.scoreA = scoreA;
	        this.scoreB = scoreB;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getTeamA() { return teamA; }
	    public void setTeamA(String teamA) { this.teamA = teamA; }

	    public String getTeamB() { return teamB; }
	    public void setTeamB(String teamB) { this.teamB = teamB; }

	    public String getVenue() { return venue; }
	    public void setVenue(String venue) { this.venue = venue; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public String getScoreA() { return scoreA; }
	    public void setScoreA(String scoreA) { this.scoreA = scoreA; }

	    public String getScoreB() { return scoreB; }
	    public void setScoreB(String scoreB) { this.scoreB = scoreB; }
	}
