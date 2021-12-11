package com.example.shirts.services;

import com.example.shirts.base.BaseTest;
import com.example.shirts.model.entity.Team;

import com.example.shirts.model.view.TeamSummaryView;
import com.example.shirts.repository.TeamRepository;
import com.example.shirts.service.TeamService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class TeamServiceTests extends BaseTest {
    private List <Team> teamList;

    @Autowired
    private TeamService teamService;
    @MockBean
    private TeamRepository teamRepository;

    @Before
    public void setupTest() {
        teamList = new ArrayList<>();
        when(teamRepository.findAll())
                .thenReturn(teamList);
    }

    @Test
    public void testGetAllTeamsWhenEmpty(){
        teamList.clear();
        List <TeamSummaryView> teamSummaryViews =  teamService.getAllTeams();
        Assert.assertEquals(0, teamSummaryViews.size());
    }

    @Test
    public void testGetAllTeamsWhenNotEmpty(){
        teamList.clear();
        Team team = new Team();
        teamList.add(team);
        List<TeamSummaryView> teamSummaryViews = teamService.getAllTeams();
        Assert.assertEquals(1, teamSummaryViews.size());
    }
}
