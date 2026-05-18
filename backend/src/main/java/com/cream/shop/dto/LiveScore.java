package com.cream.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveScore {
    private String matchId;
    private String battingTeam;
    private int runs;
    private int wickets;
    private double overs;
}
