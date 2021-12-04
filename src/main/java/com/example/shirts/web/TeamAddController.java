package com.example.shirts.web;

import com.example.shirts.model.binding.TeamAddBindingModel;
import com.example.shirts.model.binding.UserRegisterBindingModel;
import com.example.shirts.model.service.TeamAddServiceModel;
import com.example.shirts.service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TeamAddController {

    private final ModelMapper modelMapper;
    private final TeamService teamService;

    public TeamAddController(ModelMapper modelMapper, TeamService teamService) {
        this.modelMapper = modelMapper;
        this.teamService = teamService;
    }

    @GetMapping("teams/add")
    private String addTeam(){
        return "add-team";
    }

    @ModelAttribute("teamModel")
    public TeamAddBindingModel teamModel() {
        return new TeamAddBindingModel();
    }

    @PostMapping("teams/add")
    private String teamAddConfirm(@Valid TeamAddBindingModel teamModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("teamModel",teamModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.teamModel", bindingResult);
            return "redirect:/teams/add";
        }

        TeamAddServiceModel teamAddServiceModel =
                modelMapper.map(teamModel, TeamAddServiceModel.class);

        teamService.addTeam(teamAddServiceModel);

        return "redirect:/";
    }
}
