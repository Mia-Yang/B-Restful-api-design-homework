package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teams")
public class TeamController {
    @Autowired
    TeamService teamService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Team> getTeam() {
        return teamService.splitIntoTeams();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Team updateTeamName(@PathVariable int id, @RequestParam String teamName) {
        return teamService.updateTeamName(id, teamName);
    }
}
