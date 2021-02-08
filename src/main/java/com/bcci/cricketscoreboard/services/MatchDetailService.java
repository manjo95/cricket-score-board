package com.bcci.cricketscoreboard.services;

import com.bcci.cricketscoreboard.Repository.MatchDetailsRepository;
import com.bcci.cricketscoreboard.domain.scoreboard.Matchdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchDetailService {


    private final MatchDetailsRepository matchDetailsRepository;

    @Autowired
    public MatchDetailService(MatchDetailsRepository matchDetailsRepository) {
        this.matchDetailsRepository = matchDetailsRepository;
    }

    public List<Matchdetails> getMatchDetails() {
        return matchDetailsRepository.findAll();
    }

    public Matchdetails saveMatchDetails(Matchdetails matchdetails) {
        return matchDetailsRepository.save(matchdetails);
    }

    public Matchdetails getMatchDetailsById(int id) {
        return matchDetailsRepository.findById(id).orElse(null);
    }

    public String DeleteMatchDetail(int id) {
        matchDetailsRepository.deleteById(id);
        return "removed Match Details" + id;
    }

    public List<Integer> getWinScores(Integer id){

        Integer total_score = 0, fours = 0, sixes = 0, singles = 0;

        List<Integer> scorelist = new ArrayList<>();
        List<Matchdetails> winner_score= matchDetailsRepository.getWinnerScores(id);

        return getScores(total_score, fours, sixes, singles, scorelist, winner_score);

    }

    public List<Integer> getLosScores(Integer id){

        System.out.println("Lost id"+id);

        Integer total_score = 0,fours = 0,sixes = 0,singles = 0;
        List<Integer> scorelist = new ArrayList<>();

        List<Matchdetails> score= matchDetailsRepository.getLooserScores(id);

        System.out.println("list" + score);

        return getScores(total_score, fours, sixes, singles, scorelist, score);

    }

    private List<Integer> getScores(Integer total_score, Integer fours, Integer sixes, Integer singles, List<Integer> scorelist, List<Matchdetails> score) {
        for(Matchdetails temp : score){
            fours += temp.getFours();
            sixes += temp.getSixes();
            singles += temp.getSixes();
        }

        System.out.println("fours "+fours);
        System.out.println("sixes "+sixes);
        System.out.println("singles "+singles);


        total_score += (4*fours) + (6*sixes) + singles;
        scorelist.add(singles);
        scorelist.add(fours);
        scorelist.add(sixes);
        scorelist.add(total_score);

        return scorelist;
    }

}
