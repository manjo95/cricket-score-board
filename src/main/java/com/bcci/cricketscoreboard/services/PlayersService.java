package com.bcci.cricketscoreboard.services;

import com.bcci.cricketscoreboard.Repository.PlayerRepository;
import com.bcci.cricketscoreboard.domain.scoreboard.Players;
import com.bcci.cricketscoreboard.domain.scoreboard.Teams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Players> getPlayers() {
        return playerRepository.findAll();
    }

    public Players savePlayers(Players teams) {
        return playerRepository.save(teams);
    }

    public Players getPlayersId(int id) {
        return playerRepository.findById(id).orElse(null);
    }
    public String deletePlayers(int id) {
        playerRepository.deleteById(id);
        return "removed player" + id;
    }

}
