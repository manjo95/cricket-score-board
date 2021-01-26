package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players,Integer> {

    Players findByName(String name);
}
