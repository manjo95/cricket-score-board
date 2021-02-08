package com.bcci.cricketscoreboard.controllers;

import com.bcci.cricketscoreboard.domain.scoreboard.Matches;
import com.bcci.cricketscoreboard.services.MatchDetailService;
import com.bcci.cricketscoreboard.services.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MatchSummaryController {

    @Autowired
    private MatchesService matchesService;

    private final MatchDetailService matchDetailService;

    @Autowired
    public MatchSummaryController(MatchDetailService matchDetailService, MatchesService matchesService) {
        this.matchDetailService = matchDetailService;
        this.matchesService = matchesService;
    }

    @GetMapping("/matchsummary")
    public String getMatchSummary(Model model, @Param("id") Integer id){

        System.out.println("summary keyword "+ id);

        List<Matches> matches = matchesService.getMatches();
        List<Integer> winnerscore = matchDetailService.getWinScores(id);
        List<Integer> loserScores = matchDetailService.getLosScores(id);

        Integer winner_total = winnerscore.get(3);
        Integer winner_six = winnerscore.get(2);
        Integer winner_four = winnerscore.get(1);
        Integer winner_single = winnerscore.get(0);
        Integer Looser_total = loserScores.get(3);
        Integer Looser_six = loserScores.get(2);
        Integer Looser_four = loserScores.get(1);
        Integer Looser_single = loserScores.get(0);

        model.addAttribute("matches", matches);

        model.addAttribute("winner_total", winner_total);
        model.addAttribute("winner_six", winner_six);
        model.addAttribute("winner_four", winner_four);
        model.addAttribute("winner_single", winner_single);
        model.addAttribute("Looser_total", Looser_total);
        model.addAttribute("Looser_six", Looser_six);
        model.addAttribute("Looser_four", Looser_four);
        model.addAttribute("Looser_single", Looser_single);

        return "matchsummary";
    }
}
