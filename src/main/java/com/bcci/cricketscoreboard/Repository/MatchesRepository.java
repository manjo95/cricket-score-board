package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchesRepository extends JpaRepository<Matches,Integer> {

    @Query("SELECT p FROM Matches p WHERE CONCAT(p.name, ' ',p.winner.name,p.looser.name) LIKE %?1%")
    public List<Matches> searchMatches(String keyword);
}
