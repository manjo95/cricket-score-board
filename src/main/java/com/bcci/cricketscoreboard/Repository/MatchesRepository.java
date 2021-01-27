package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchesRepository extends JpaRepository<Matches,Integer> {
}
