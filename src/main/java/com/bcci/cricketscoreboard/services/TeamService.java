package com.bcci.cricketscoreboard.services;

import com.bcci.cricketscoreboard.Repository.TeamRepository;
import com.bcci.cricketscoreboard.domain.scoreboard.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Teams> getTeams() {
        return teamRepository.findAll();
    }

    public Teams saveTeams(Teams teams) {
        return teamRepository.save(teams);
    }

    public Teams getTeamById(int id) {
        return teamRepository.findById(id).orElse(null);
    }
    public String deleteTeams(int id) {
        teamRepository.deleteById(id);
        return "removed team" + id;
    }

}
