package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Matchdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchDetailsRepository extends JpaRepository<Matchdetails,Integer> {

    @Query("SELECT p FROM Matchdetails p WHERE p.matchid.winner.id = p.playerid.teams.id and p.matchid.id = ?1")
    public List<Matchdetails> getWinnerScores(Integer keyword);

    @Query("SELECT p FROM Matchdetails p WHERE p.matchid.looser.id = p.playerid.teams.id and p.matchid.id = ?1")
    public List<Matchdetails> getLooserScores(Integer keyword);
}
