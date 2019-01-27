package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.ResultTeam;

public interface ResultTeamService {

	ResultTeam findById(Integer id);
	
	void save(ResultTeam resultTeam);
	
	List<ResultTeam> findAll();
	
	List<ResultTeam> sorted();
	
	ResultTeam updateGame(MatchService matchService, ResultTeam resTeam);
}
