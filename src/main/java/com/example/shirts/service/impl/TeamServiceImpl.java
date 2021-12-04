package com.example.shirts.service.impl;

import com.example.shirts.model.entity.*;
import com.example.shirts.model.service.TeamAddServiceModel;
import com.example.shirts.model.view.TeamDetailsView;
import com.example.shirts.model.view.TeamSummaryView;
import com.example.shirts.repository.TeamRepository;
import com.example.shirts.repository.UserRepository;
import com.example.shirts.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private ModelMapper modelMapper;
    private TeamRepository teamRepository;
    private UserRepository userRepository;

    public TeamServiceImpl(ModelMapper modelMapper, TeamRepository teamRepository, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addTeam(TeamAddServiceModel teamAddServiceModel) {
        Team newTeam = modelMapper.map(teamAddServiceModel, Team.class);
        teamRepository.save(newTeam);
    }

    @Override
    public List<TeamSummaryView> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDetailsView findTeamById(Long id, String currentUser) {
        return this.teamRepository.findById(id)
                .map(t -> mapDetailsView(currentUser,t)).get();
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    private TeamSummaryView map(Team team) {
        TeamSummaryView summaryView = this.modelMapper
                .map(team, TeamSummaryView.class);
        return summaryView;
    }

    private TeamDetailsView mapDetailsView(String currentUser, Team team) {
        TeamDetailsView teamDetailsView = this.modelMapper.map(team, TeamDetailsView.class);
        teamDetailsView.setCanDelete(isAdmin(userRepository.findByUsername(currentUser).orElseThrow()));
        return teamDetailsView;
    }

    private boolean isAdmin(User user) {
        return user.
                getRoles().
                stream().
                map(UserRole::getRole).
                anyMatch(r -> r == UserRoleEnum.ADMIN);
    }
}
