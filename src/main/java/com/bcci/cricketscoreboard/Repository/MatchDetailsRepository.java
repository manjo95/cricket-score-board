package com.bcci.cricketscoreboard.Repository;

import com.bcci.cricketscoreboard.domain.scoreboard.Matchdetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchDetailsRepository extends JpaRepository<Matchdetails,Integer> {
}
