package com.example.shirts.service;

import com.example.shirts.model.service.TeamAddServiceModel;
import com.example.shirts.model.view.TeamDetailsView;
import com.example.shirts.model.view.TeamSummaryView;

import java.util.List;

public interface TeamService {
    void addTeam(TeamAddServiceModel teamAddServiceModel);

    List<TeamSummaryView> getAllTeams();

    TeamDetailsView findTeamById(Long id, String currentUser);

    void deleteTeam(Long id);

}
