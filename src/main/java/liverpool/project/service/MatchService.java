package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.Match;

public interface MatchService {

	
	void save(Match match);
	
	Match findById(Integer id);
	
	List<Match> findByTeams(String nameHome, String nameGuest);
	
	List<Match> findByNumberTour(Integer tour);
	
	List<Match> findByNameTeam(String name);
	
}
