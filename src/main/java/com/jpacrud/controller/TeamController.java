package com.jpacrud.controller;

import com.jpacrud.domain.Member;
import com.jpacrud.domain.Team;
import com.jpacrud.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/index")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @PostMapping("/teamcreate") //팀 생성, CREATE
    public String create(@RequestBody Team team) {

        teamRepository.save(team);

        return team.getTeamName() + " 팀 창단을 축하드립니다~~~!!";
    }


//    @GetMapping("/teamread") //조회, READ, Team
//    public Team teamread(@RequestParam Long teamId) {
//        Optional<Team> team = teamRepository.findById(teamId);
//        List<Member> memberList = team.get().getMembers();
//
//
//        return team.get();
//    }


    @PutMapping("/teamupdate") // 수정, UPDATE, Team
    public Optional<Team> team(@RequestParam Long teamId, @RequestBody Team team) {

        Optional<Team> updateTeam = teamRepository.findById(teamId);

        updateTeam.ifPresent(selectTeam -> {

            selectTeam.setTeamName(team.getTeamName());
            selectTeam.setTeamAddress(team.getTeamAddress());

            teamRepository.save(selectTeam);
        });
        return updateTeam;
    }

}
