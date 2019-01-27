package liverpool.project.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import liverpool.project.entity.Match;
import liverpool.project.entity.Team;
import liverpool.project.entity.User;
import liverpool.project.repository.MatchRepository;
import liverpool.project.service.LeagueTourService;
import liverpool.project.service.MatchService;
import liverpool.project.service.TeamService;
import liverpool.project.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;
	@Autowired
	private MatchService matchService;
	@Autowired
	private LeagueTourService tourService;
	@Autowired
	private TeamService teamService;


	@GetMapping("/profile")
	public String showProfileAdmin(Principal principal, Model model) {
		User user = userService.findUserByLogin(principal.getName());
		model.addAttribute("userModel", user);
		return "adminProfile";
	}

	@GetMapping("/update/result/{tour}")
	public String updateResultTout(@PathVariable("tour") int tour, Model model) {
		List<Match> matches = matchService.findByNumberTour(tour);
		Iterator<Match> iterator = matches.iterator();
		while (iterator.hasNext()) {
			Match match = iterator.next();
			match.setHomeTeamObject(teamService.findTeamByName(match.getHomeTeam()));
			match.setGuestTeamObject(teamService.findTeamByName(match.getGuestTeam()));
			matchService.save(match);
		}
		model.addAttribute("selectedTour", tour);
		model.addAttribute("listMatches", matches);
		List<Integer> tourList = tourService.findAllNumberTour();
		model.addAttribute("tourList", tourList);

		model.addAttribute("modelMatch", new Match());
		return "updateTour";
	}

	@GetMapping("/update/match/{match}")
	public String updateMatch(@PathVariable("match") int matchId, Model model) {
		List<Team> teamList = teamService.findAll();
		List<String> teams = new ArrayList<>();
		Iterator<Team> teamIterator = teamList.iterator();
		while (teamIterator.hasNext()) {

			teams.add(teamIterator.next().getName());

		}
		model.addAttribute("teams", teams);
		Match match = matchService.findById(matchId);
		model.addAttribute("teamHome",match.getHomeTeam());
		model.addAttribute("teamGuest",match.getGuestTeam());
		model.addAttribute("modelMatch", match);
		return "updateMatch";
	}

	@PostMapping("/set")
	public String setTour(@RequestParam("settedTour") String setTour) {
		return "redirect:/admin/update/result/" + setTour;
	}

	@PostMapping("/save")
	public String saveMatch(@ModelAttribute("modelMatch") Match match, @RequestParam("id") int id) {
	
		Match matchSave = matchService.findById(id);
		
		if (match.getHomeTeam().equals(match.getGuestTeam())) {
			return "redirect:/";
		}
		
		List<Match> matchesTour =matchService.findByNumberTour(matchSave.getTour().getId());
		List<String> teamsTour = new ArrayList<>();
		Iterator<Match> matchesTourIterator = matchesTour.iterator();
		while(matchesTourIterator.hasNext()) {
			Match match1 = matchesTourIterator.next();
			if (match1.getId()!=id) {
				teamsTour.add(match1.getHomeTeam());
				teamsTour.add(match1.getGuestTeam());
			}
			
		}
		if (teamsTour.contains(match.getHomeTeam())||teamsTour.contains(match.getGuestTeam())) {
			return "redirect:/table";
		}
		
		List<Match> matches = matchService.findByTeams(match.getHomeTeam(), match.getGuestTeam());

		if ((matches.size() == 1 && matches.get(0).getId() == match.getId()) || matches.size() == 0) {

			matchSave.setHomeTeam(match.getHomeTeam());
			matchSave.setGuestTeam(match.getGuestTeam());
			matchSave.setGoalHome(match.getGoalHome());
			matchSave.setGoalGuest(match.getGoalGuest());
			matchService.save(matchSave);
			System.out.println(match.getId() + "+" + match);
			return "redirect:/admin/update/result/" + matchSave.getTour().getId();

		} else {
			return "redirect:/";
		}

	}
	@GetMapping("/clear/match/{match}")
	public String clearMatch(@PathVariable("match") int matchId) {
		Match match = matchService.findById(matchId);
		match.setHomeTeam(null);
		match.setGuestTeam(null);
		match.setGoalHome(null);
		match.setGoalGuest(null);
		match.setGuestTeamObject(null);
		match.setHomeTeamObject(null);
		matchService.save(match);
		 return "redirect:/admin/update/result/" + match.getTour().getId();
	}
	
}
