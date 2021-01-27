package com.bcci.cricketscoreboard.controllers;

import com.bcci.cricketscoreboard.domain.scoreboard.Players;
import com.bcci.cricketscoreboard.domain.scoreboard.Teams;
import com.bcci.cricketscoreboard.services.PlayersService;
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
public class PlayersController {

    @Autowired
    private PlayersService playersService;

    @Autowired
    private TeamService teamService;

//    @GetMapping({"/playerslist", "playerslist"})
//    public String findAllPlayers(Model model) {
//        List<Players> playersList = playersService.getPlayers();
//        model.addAttribute("playersList", playersList);
//        return "playersList";
//    }
    @GetMapping({"/playerslist", "playerslist"})
    public String findAllPlayers(Model model, @Param("keyword") String keyword) {
        List<Players> playersList = playersService.searchAllPlayers(keyword);
        model.addAttribute("playersList", playersList);
        model.addAttribute("keyword", keyword);
        return "playersList";
    }

    @GetMapping({"/players/new","/players/new"})
    public String savePlayersForm(Model model){
        List<Teams> teamlist = teamService.getTeams();
        model.addAttribute("players", new Players());
        model.addAttribute("teamlist", teamlist);
        return "playerform";
    }

    @PostMapping("/saveplayer")
    public String savePlayers(Players players, Model model, @Param("keyword") String keyword){
        playersService.savePlayers(players);
        List<Players> playersList = playersService.searchAllPlayers(keyword);
        model.addAttribute("playersList", playersList);
        model.addAttribute("keyword", keyword);
        return "playersList";
    }

    @GetMapping("/playerslist/edit/{id}")
    public String editPlayerForm(@PathVariable("id") Integer id, Model model){
        Players players = playersService.getPlayersId(id);
        List<Teams> teamlist = teamService.getTeams();
        model.addAttribute("players",players);
        model.addAttribute("teamlist", teamlist);
        return "playerform";
    }
    @GetMapping("/playerslist/delete/{id}")
    public String deletePlayer(@PathVariable("id") Integer id, Model model, @Param("keyword") String keyword){
        String del = playersService.deletePlayers(id);
        List<Players> playersList = playersService.searchAllPlayers(keyword);
        model.addAttribute("playersList", playersList);
        model.addAttribute("keyword", keyword);
        return "playersList";
    }
}
