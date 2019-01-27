package liverpool.project.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liverpool.project.entity.Match;
import liverpool.project.entity.ResultTeam;
import liverpool.project.entity.Team;
import liverpool.project.repository.ResultTeamRepository;
import liverpool.project.service.MatchService;
import liverpool.project.service.ResultTeamService;

@Service
public class ResultTeamImpl implements ResultTeamService{

	@Autowired private ResultTeamRepository resultTeamRepository;
	
	@Override
	public ResultTeam findById(Integer id) {
	
		return resultTeamRepository.getOne(id);
	}

	@Override
	public void save(ResultTeam resultTeam) {
		resultTeamRepository.save(resultTeam);
		
	}

	@Override
	public List<ResultTeam> findAll() {
		return resultTeamRepository.findAll();
	}

	@Override
	public List<ResultTeam> sorted() {
		return resultTeamRepository.sorted();
	}

	@Override
	 public ResultTeam updateGame(MatchService matchService,ResultTeam resTeam) {
		Team team=resTeam.getTeam();
		int gameW=0;
		int gameD=0;
		int gameL=0;
		int goalS=0;
		int goalM=0;
		int p=0;
		List<Match> matches = matchService.findByNameTeam(team.getName());
		Iterator<Match> iterator=matches.listIterator();
		resTeam.setTeam(team);
		resTeam.setGame(matches.size());
		while(iterator.hasNext()) {
			Match match = iterator.next();
			if (match.getGoalHome()==null||match.getGoalGuest()==null) {
				continue;
			}
			if (match.getHomeTeam().equals(team.getName())) {
				goalS+=match.getGoalHome();
				goalM+=match.getGoalGuest();
				if (match.getGoalHome()>match.getGoalGuest()) {
					p+=3;
					gameW++;
				}else if (match.getGoalHome()<match.getGoalGuest()) {
					gameL++;
				}else {
					p++;
					gameD++;
				}
			}else {
				goalM+=match.getGoalHome();
				goalS+=match.getGoalGuest();
				if (match.getGoalHome()>match.getGoalGuest()) {
					gameL++;
				}else if(match.getGoalHome()<match.getGoalGuest()) {
					p+=3;
					gameW++;
				}else {
					p++;
					gameD++;
				}
			}
			}
		resTeam.setGameDraw(gameD);
		resTeam.setGameLose(gameL);
		resTeam.setGameWin(gameW);
		resTeam.setGoalMiss(goalM);
		resTeam.setGoalScore(goalS);
		resTeam.setPoint(p);
		return resTeam;
		}
}
