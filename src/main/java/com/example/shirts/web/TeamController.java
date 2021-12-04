package com.example.shirts.web;

import com.example.shirts.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams/all")
    public String allOffers(Model model) {
        model.addAttribute("teams", teamService.getAllTeams());
        return "teams";
    }

    @GetMapping("/teams/{id}/details")
    public String showTeamInfo(
            @PathVariable Long id, Model model,
            Principal principal) {
        model.addAttribute("team", this.teamService.findTeamById(id, principal.getName()));
        return "team-info";
    }

    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable Long id) {

        teamService.deleteTeam(id);

        return "redirect:/teams/all";
    }
}
