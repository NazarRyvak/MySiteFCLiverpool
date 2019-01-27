package liverpool.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liverpool.project.entity.Team;
import liverpool.project.repository.TeamRepository;
import liverpool.project.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Override
	public void saveTeam(Team team) {
		teamRepository.save(team);
	}

	@Override
	public Team findTeamById(Integer id) {
		return teamRepository.getOne(id);
	}

	@Override
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

	@Override
	public Team findTeamByName(String name) {
		return teamRepository.findTeamByName(name);
	}

}
