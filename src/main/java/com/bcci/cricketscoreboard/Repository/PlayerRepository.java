package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Players,Integer> {

    @Query("SELECT p FROM Players p WHERE CONCAT(p.name, ' ', p.teams.name, ' ', p.name, ' ') LIKE %?1%")
    public List<Players> searchPlayer(String keyword);

}
