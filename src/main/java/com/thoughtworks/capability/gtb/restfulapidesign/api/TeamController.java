package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<List> getTeam() {
        return ResponseEntity.status(HttpStatus.OK).body(teamService.splitIntoTeams());
    }

    @PatchMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeamName(@PathVariable int id, @RequestParam String teamName) {
        return ResponseEntity.status(HttpStatus.OK).body(teamService.updateTeamName(id, teamName));
    }
}
