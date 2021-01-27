package com.bcci.cricketscoreboard.services;

import com.bcci.cricketscoreboard.Repository.MatchesRepository;
import com.bcci.cricketscoreboard.domain.scoreboard.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchesService {

    @Autowired
    private MatchesRepository matchesRepository;

    public List<Matches> getMatches() {
        return matchesRepository.findAll();
    }

    public Matches saveMatches(Matches matches) {
        return matchesRepository.save(matches);
    }

    public Matches getMatchesById(int id) {
        return matchesRepository.findById(id).orElse(null);
    }

    public String deleteMatches(int id) {
        matchesRepository.deleteById(id);
        return "removed Match" + id;
    }

    public List<Matches> searchAllMatches(String keyword) {
        if (keyword != null) {
            return matchesRepository.searchMatches(keyword);
        }
        return matchesRepository.findAll();
    }
}
