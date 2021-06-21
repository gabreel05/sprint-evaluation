package br.com.gabriel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gabriel.model.Team;
import br.com.gabriel.model.TeamDetail;
import br.com.gabriel.repository.TeamDetailRepository;
import br.com.gabriel.repository.TeamRepository;

@Controller
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TeamDetailRepository teamDetailRepository;
	
	@GetMapping("/team")
	public String team(Model model) {
		List<Team> teams = teamRepository.findAll();
		List<TeamDetail> teamDetails = teamDetailRepository.findAll();
		
		model.addAttribute("teams", teams);
		model.addAttribute("teamDetails", teamDetails);
		
		return "team/team";
	}
	
	@GetMapping("/team/add_team_form")
	public String addTeamForm(Team team) {
		return "team/add_team_form";
	}

	@PostMapping("/team/add_team")
	public String addTeam(@Valid Team team, BindingResult result) {
		if (result.hasErrors()) {
			return "team/add_team_form";
		}

		teamRepository.save(team);

		return "redirect:/team";
	}

	@RequestMapping(path = "/team/update_team/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(@PathVariable("id") long id, @Valid Team team, BindingResult result, Model model) {
		if (result.hasErrors()) {

			team.setTeamId(id);
			
			model.addAttribute("team", team);
						
			return "team/update_team_form";

		}

		teamRepository.save(team);

		return "redirect:/team";
	}

	@GetMapping("/team/delete_team/{id}")
	public String delete(@PathVariable("id") long id) {
		teamRepository.deleteById(id);

		return "redirect:/team";
	}
	
}
