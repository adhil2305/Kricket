package com.cream.shop.read;
//
public class read {
//
}
//
//
//Perfect 😎 — you want a simple, clean CricBuzz-style app using:
//
//Spring Boot (no Lombok, no Axios, just plain Java & REST)
//
//React (using fetch, not Axios)
//
// this step-by-step — fully minimal, but working.
//
//🏗️ Project Structure
//
//We’ll build two folders:
//
//cricbuzz-backend/
//cricbuzz-frontend/
//
//🧩 BACKEND — Spring Boot (No Lombok)
//1️⃣ Create Spring Boot Project
//
//Go to https://start.spring.io
//
//Choose:
//
//Project: Maven
//
//Language: Java
//
//Spring Boot: 3.3.x
//
//Dependencies:
//
//Spring Web
//
//Spring Data JPA
//
//H2 Database (so we don’t need MySQL)
//
//Download & unzip → rename folder to cricbuzz-backend
//
//2️⃣ Project Structure
//src/
// ├── main/
// │   ├── java/com/cricbuzz/backend/
// │   │     ├── CricbuzzBackendApplication.java
// │   │     ├── controller/
// │   │     │     └── MatchController.java
// │   │     ├── model/
// │   │     │     └── Match.java
// │   │     └── repository/
// │   │           └── MatchRepository.java
// │   └── resources/
// │         └── application.properties
//
//3️⃣ Match.java
//package com.cricbuzz.backend.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class Match {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String teamA;
//    private String teamB;
//    private String venue;
//    private String status; // Live, Upcoming, Completed
//    private String scoreA;
//    private String scoreB;
//
//    public Match() {}
//
//    public Match(String teamA, String teamB, String venue, String status, String scoreA, String scoreB) {
//        this.teamA = teamA;
//        this.teamB = teamB;
//        this.venue = venue;
//        this.status = status;
//        this.scoreA = scoreA;
//        this.scoreB = scoreB;
//    }
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getTeamA() { return teamA; }
//    public void setTeamA(String teamA) { this.teamA = teamA; }
//
//    public String getTeamB() { return teamB; }
//    public void setTeamB(String teamB) { this.teamB = teamB; }
//
//    public String getVenue() { return venue; }
//    public void setVenue(String venue) { this.venue = venue; }
//
//    public String getStatus() { return status; }
//    public void setStatus(String status) { this.status = status; }
//
//    public String getScoreA() { return scoreA; }
//    public void setScoreA(String scoreA) { this.scoreA = scoreA; }
//
//    public String getScoreB() { return scoreB; }
//    public void setScoreB(String scoreB) { this.scoreB = scoreB; }
//}
//	
//4️⃣ MatchRepository.java
//package com.cricbuzz.backend.repository;
//
//import com.cricbuzz.backend.model.Match;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface MatchRepository extends JpaRepository<Match, Long> {
//    List<Match> findByStatus(String status);
//}
//
//5️⃣ MatchController.java
//package com.cricbuzz.backend.controller;
//
//import com.cricbuzz.backend.model.Match;
//import com.cricbuzz.backend.repository.MatchRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/matches")
//@CrossOrigin(origins = "http://localhost:3000")
//public class MatchController {
//
//    private final MatchRepository matchRepository;
//
//    public MatchController(MatchRepository matchRepository) {
//        this.matchRepository = matchRepository;
//    }
//
//    @GetMapping
//    public List<Match> getAllMatches() {
//        return matchRepository.findAll();
//    }
//
//    @GetMapping("/live")
//    public List<Match> getLiveMatches() {
//        return matchRepository.findByStatus("Live");
//    }
//
//    @PostMapping
//    public Match addMatch(@RequestBody Match match) {
//        return matchRepository.save(match);
//    }
//}
//
//6️⃣ application.properties
//spring.h2.console.enabled=true
//spring.datasource.url=jdbc:h2:mem:cricbuzzdb
//spring.datasource.driverClassName=org.h2.Driver
//spring.jpa.hibernate.ddl-auto=create
//server.port=8080
//
//7️⃣ (Optional) Insert Sample Data
//
//In CricbuzzBackendApplication.java:
//
//package com.cricbuzz.backend;
//
//import com.cricbuzz.backend.model.Match;
//import com.cricbuzz.backend.repository.MatchRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class CricbuzzBackendApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(CricbuzzBackendApplication.class, args);
//    }
//
//    @Bean
//    public CommandLineRunner dataLoader(MatchRepository repo) {
//        return args -> {
//            repo.save(new Match("India", "Australia", "Delhi", "Live", "250/3", "230/6"));
//            repo.save(new Match("England", "Pakistan", "Lahore", "Upcoming", "", ""));
//        };
//    }
//}
//
//✅ Run Backend
//
//In terminal:
//
//cd cricbuzz-backend
//./mvnw spring-boot:run
//
//
//API endpoints:
//
//All Matches → http://localhost:8080/api/matches
//
//Live Matches → http://localhost:8080/api/matches/live
//
//⚛️ FRONTEND — React (No Axios)
//1️⃣ Create React App
//npx create-react-app cricbuzz-frontend
//cd cricbuzz-frontend
//
//2️⃣ Clean Default Files
//
//Delete unused stuff in src/:
//Keep only:
//
//src/
// ├── App.js
// ├── index.js
// └── MatchList.js
//
//3️⃣ MatchList.js
//import React, { useEffect, useState } from "react";
//
//function MatchList() {
//  const [matches, setMatches] = useState([]);
//
//  useEffect(() => {
//    fetch("http://localhost:8080/api/matches")
//      .then(res => res.json())
//      .then(data => setMatches(data))
//      .catch(err => console.error("Error fetching matches:", err));
//  }, []);
//
//  return (
//    <div style={{ padding: "1rem" }}>
//      <h2>🏏 CricBuzz Clone</h2>
//      {matches.map((match) => (
//        <div
//          key={match.id}
//          style={{
//            border: "1px solid #ccc",
//            borderRadius: "8px",
//            padding: "10px",
//            margin: "10px 0",
//          }}
//        >
//          <h3>{match.teamA} vs {match.teamB}</h3>
//          <p><strong>Venue:</strong> {match.venue}</p>
//          <p><strong>Status:</strong> {match.status}</p>
//          <p><strong>Score:</strong> {match.scoreA} - {match.scoreB}</p>
//        </div>
//      ))}
//    </div>
//  );
//}
//
//export default MatchList;
//
//4️⃣ App.js
//import React from "react";
//import MatchList from "./MatchList";
//
//function App() {
//  return (
//    <div>
//      <MatchList />
//    </div>
//  );
//}
//
//export default App;
//
//5️⃣ Run Frontend
//npm start
//
//
//Frontend → http://localhost:3000
//
//It will fetch live match data from your backend 🎯
//
//✅ Final Result
//
//Backend: http://localhost:8080/api/matches (Spring Boot REST API)
//
//Frontend: http://localhost:3000 (React UI using fetch)
//
//No Axios, No Lombok, No DB setup needed (H2 in-memory)
//
//Would you like me to now show how to add a “Live Matches Only” toggle in the React UI (using /api/matches/l
