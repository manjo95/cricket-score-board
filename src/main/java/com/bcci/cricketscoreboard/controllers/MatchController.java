package com.bcci.cricketscoreboard.controllers;

import com.bcci.cricketscoreboard.domain.scoreboard.Matches;
import com.bcci.cricketscoreboard.domain.scoreboard.Players;
import com.bcci.cricketscoreboard.domain.scoreboard.Teams;
import com.bcci.cricketscoreboard.services.MatchesService;
import com.bcci.cricketscoreboard.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MatchController {

    @Autowired
    private MatchesService matchesService;

    @Autowired
    private TeamService teamService;

//    @GetMapping("/matches")
//    public String getMatches(Model model){
//        List<Matches> matchlist = matchesService.getMatches();
//        model.addAttribute("matchlist",matchlist);
//        return "matchList";
//    }
    @GetMapping({"/matches", "matches"})
    public String getMatches(Model model, @Param("keyword") String keyword) {
        List<Matches> matchlist = matchesService.searchAllMatches(keyword);
        model.addAttribute("matchlist", matchlist);
        model.addAttribute("keyword", keyword);
        return "matchList";
    }

    @GetMapping("/matches/new")
    public String createMatches(Model model){
        List<Teams> teams = teamService.getTeams();
        model.addAttribute("teams",teams);
        model.addAttribute("matches",new Matches());
        return "newMatchForm";
    }

    @PostMapping("/saveMatch")
    public String saveMatches(Matches matches, Model model, @Param("keyword") String keyword){
        matchesService.saveMatches(matches);
        List<Matches> matchlist = matchesService.searchAllMatches(keyword);
        model.addAttribute("matchlist", matchlist);
        model.addAttribute("keyword", keyword);
        return "matchList";
    }
    @GetMapping("/matchList/edit/{id}")
    public String editMatches(@PathVariable("id") Integer id, Model model){
        Matches matches = matchesService.getMatchesById(id);
        List<Teams> teams = teamService.getTeams();
        model.addAttribute("matches",matches);
        model.addAttribute("teams", teams);
        return "newMatchForm";
    }
    @GetMapping("/matchList/delete/{id}")
    public String deleteMatches(@PathVariable("id") Integer id, Model model, @Param("keyword") String keyword){
        String del = matchesService.deleteMatches(id);
        List<Matches> matchlist = matchesService.searchAllMatches(keyword);
        model.addAttribute("matchlist", matchlist);
        model.addAttribute("keyword", keyword);
        return "matchList";
    }
}
