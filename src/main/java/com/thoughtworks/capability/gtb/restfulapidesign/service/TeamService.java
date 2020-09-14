package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    StudentService studentService;

    final int teamNum = 6;
    private List<Team> teams = new ArrayList<>();


    public TeamService() {
        for (int i = 0; i < teamNum; i++) {
            teams.add(Team.builder().id(i + 1).name("Team " + (i + 1)).note("").teamMembers(null).build());
        }
    }

    public List<Team> splitIntoTeams() {
        List<Student> students = studentService.getStudentsByGender(null);
        Collections.shuffle(students);

        for (Team team : teams) {
            List<Student> members = new ArrayList<>();
            for (int i = 0; i < students.size(); i++) {
                int remainder = (i + 1) % teamNum;
                if (remainder == team.getId()) {
                    members.add(students.get(i));
                }
                if (team.getId() == teamNum) {
                    if (remainder == 0) {
                        members.add(students.get(i));
                    }
                }
                team.setTeamMembers(members);
            }
        }
        return teams;
    }
}
