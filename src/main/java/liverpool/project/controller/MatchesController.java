package liverpool.project.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import liverpool.project.entity.Match;
import liverpool.project.entity.ResultTeam;
import liverpool.project.service.LeagueTourService;
import liverpool.project.service.MatchService;
import liverpool.project.service.ResultTeamService;

@Controller
public class MatchesController {

	@Autowired private MatchService matchService;
	
	@Autowired private LeagueTourService tourService;
	
	@Autowired private ResultTeamService resultTeamService;
	
	@GetMapping("/result/{tour}")
	public String showResult(@PathVariable("tour")int tour, Model model) {
	List<Match> matches = matchService.findByNumberTour(tour);
	model.addAttribute("selectedTour", tour);
	 model.addAttribute("listMatches", matches);
	 List<Integer> tourList = tourService.findAllNumberTour();
	 model.addAttribute("tourList", tourList);
		return "showResult";
	}
	@PostMapping("/set")
	public String setTour(@RequestParam("settedTour") String setTour) {
		return "redirect:/result/"+setTour;
	}
	@GetMapping("/table")
	public String showTable(Model model) {
		List<ResultTeam> teamsList = resultTeamService.findAll();
		Iterator<ResultTeam> iterator =teamsList.iterator();
		while (iterator.hasNext()) {
			ResultTeam resultTeam = iterator.next();
			resultTeamService.updateGame(matchService, resultTeam);
			resultTeamService.save(resultTeam);
		}
		List<ResultTeam> sortedTeam =resultTeamService.sorted();
		model.addAttribute("sortedTeam", sortedTeam);
		return "showTable";
	}
	
}
