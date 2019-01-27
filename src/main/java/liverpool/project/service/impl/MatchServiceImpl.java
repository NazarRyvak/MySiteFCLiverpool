package liverpool.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liverpool.project.entity.Match;
import liverpool.project.repository.MatchRepository;
import liverpool.project.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired private MatchRepository matchRepository;
	
	@Override
	public void save(Match match) {
		matchRepository.save(match);
		
	}

	@Override
	public List<Match> findByTeams(String nameHome, String nameGuest) {
		return matchRepository.findByTeams(nameHome, nameGuest);
	}

	@Override
	public List<Match> findByNumberTour(Integer tour) {
		return matchRepository.findByNumberTour(tour);
	}

	@Override
	public Match findById(Integer id) {
		return matchRepository.getOne(id);
	}

	@Override
	public List<Match> findByNameTeam(String name) {
		return matchRepository.findByNameTeam(name);
	}

}
