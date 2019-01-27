package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.Team;

public interface TeamService {

	void saveTeam(Team team);

	Team findTeamById(Integer id);

	List<Team> findAll();

	Team findTeamByName(String name);

	

}
