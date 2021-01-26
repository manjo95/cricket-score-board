package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Teams, Integer> {
    Teams findByName(String name);
}
