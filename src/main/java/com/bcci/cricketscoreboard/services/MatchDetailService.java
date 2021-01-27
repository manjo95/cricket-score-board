package com.bcci.cricketscoreboard.services;

import com.bcci.cricketscoreboard.Repository.MatchDetailsRepository;
import com.bcci.cricketscoreboard.domain.scoreboard.Matchdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchDetailService {

    @Autowired
    private MatchDetailsRepository matchDetailsRepository;

    public List<Matchdetails> getMatchdetails() {
        return matchDetailsRepository.findAll();
    }

    public Matchdetails saveMatchDetails(Matchdetails matchdetails) {
        return matchDetailsRepository.save(matchdetails);
    }

    public Matchdetails getMatchdetailsById(int id) {
        return matchDetailsRepository.findById(id).orElse(null);
    }

    public String DeleteMatchDetail(int id) {
        matchDetailsRepository.deleteById(id);
        return "removed Match Details" + id;
    }

}
