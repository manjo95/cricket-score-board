package com.bcci.cricketscoreboard.controllers;

import com.bcci.cricketscoreboard.Repository.TeamRepository;
import com.bcci.cricketscoreboard.domain.scoreboard.Teams;
import com.bcci.cricketscoreboard.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeamController {

    @Autowired
    private TeamService service;

//    @GetMapping({"/teamlist","teamList"})
//    public String listTeams(Model model) {
//        List<Teams> teamsList = repository.findAll();
//        model.addAttribute("teamsList", teamsList);
//        return "teams";
//    }

    @GetMapping({"/teamlist", "teamList"})
    public String findAllTeams(Model model) {
        List<Teams> teamsList = service.getTeams();
        model.addAttribute("teamsList", teamsList);
        return "teams";
    }

    @GetMapping("/teams/new")
    public String ShowNewTeamForm(Model model){
        model.addAttribute("team",new Teams());
        return "newteamform";
    }

    @PostMapping("/saveteam")
    public String SaveTeams(Teams teams){
        service.saveTeams(teams);
        return "redirect:/teamlist";
    }
    @GetMapping("/teams/edit/{id}")
    public String editTeamForm(@PathVariable("id") Integer id, Model model){
        Teams teams = service.getTeamById(id);
        model.addAttribute("team",teams);
        return "newteamform";
    }
    @GetMapping("/teams/delete/{id}")
    public String deleteTeamForm(@PathVariable("id") Integer id){
        String del = service.deleteTeams(id);
        return "redirect:/teamlist";
    }



}
