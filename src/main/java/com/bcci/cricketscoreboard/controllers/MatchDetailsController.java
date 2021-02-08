package com.bcci.cricketscoreboard.controllers;

import com.bcci.cricketscoreboard.domain.scoreboard.Matchdetails;
import com.bcci.cricketscoreboard.domain.scoreboard.Matches;
import com.bcci.cricketscoreboard.domain.scoreboard.Players;
import com.bcci.cricketscoreboard.services.MatchDetailService;
import com.bcci.cricketscoreboard.services.MatchesService;
import com.bcci.cricketscoreboard.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MatchDetailsController {

    @Autowired
    private MatchesService matchesService;

    @Autowired
    private MatchDetailService matchDetailService;

    @Autowired
    private PlayersService playersService;

    @GetMapping("/matchDetails")
    public String getMatchDetails(Model model){
        List<Matchdetails> matchdetails = matchDetailService.getMatchDetails();
        model.addAttribute("matchdetails",matchdetails);
        return "matchdetaillist";
    }

    @GetMapping("matchDetails/new")
    public String newMatchDetail(Model model){
        List<Players> playersList = playersService.getPlayers();
        List<Matches> matches = matchesService.getMatches();
        model.addAttribute("playersList", playersList);
        model.addAttribute("matches",matches);
        model.addAttribute("matchdetail", new Matchdetails());
        return "matchdetailform";
    }

    @PostMapping("/matchDetails/new/save")
    public String saveMatchDetail(Matchdetails matchdetailsmodel, Model model){
        matchDetailService.saveMatchDetails(matchdetailsmodel);
        List<Matchdetails> matchdetails = matchDetailService.getMatchDetails();
        model.addAttribute("matchdetails",matchdetails);
        return "matchdetaillist";
    }
    @GetMapping("/matchDetails/edit/{id}")
    public String editMatchDetails(@PathVariable("id") Integer id, Model model){
        Matchdetails mdetails = matchDetailService.getMatchDetailsById(id);
        List<Players> playersList = playersService.getPlayers();
        List<Matches> matches = matchesService.getMatches();
        model.addAttribute("playersList",playersList);
        model.addAttribute("matches", matches);
        model.addAttribute("matchdetail", mdetails);
        return "matchdetailform";
    }
    @GetMapping("/matchDetails/delete/{id}")
    public String deleteMatchDetail(@PathVariable("id") Integer id, Model model){
        String del = matchDetailService.DeleteMatchDetail(id);
        List<Matchdetails> matchdetails = matchDetailService.getMatchDetails();
        model.addAttribute("matchdetails",matchdetails);
        return "matchdetaillist";
    }








}
