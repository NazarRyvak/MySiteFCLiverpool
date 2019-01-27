package liverpool.project.bootstrap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import liverpool.project.entity.LeagueTour;
import liverpool.project.entity.Match;
import liverpool.project.entity.Player;
import liverpool.project.entity.ResultTeam;
import liverpool.project.entity.Team;
import liverpool.project.entity.User;
import liverpool.project.entity.enums.Position;
import liverpool.project.entity.enums.UserRole;
import liverpool.project.repository.LeagueTourRepository;
import liverpool.project.repository.MatchRepository;
import liverpool.project.repository.PlayerRepository;
import liverpool.project.repository.ResultTeamRepository;
import liverpool.project.repository.TeamRepository;
import liverpool.project.repository.UserRepository;


@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired private UserRepository userRepository;
	@Autowired private LeagueTourRepository tourRepository;
	@Autowired private MatchRepository matchRepository;
	@Autowired private TeamRepository teamRepository;
	@Autowired private ResultTeamRepository resultTeamRepository;
	@Autowired private PlayerRepository playerRepository;
	
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		if (userRepository.count()==0) {
			User userAdmin = User.builder().login("admin").email("ryvaknt96@gmail.com").password(passwordEncoder.encode("20081996nr")).role(UserRole.ROLE_ADMIN).build();
			userRepository.save(userAdmin);
			User user = User.builder().login("user").email("ryva_nazar@ukr.net").password(passwordEncoder.encode("123")).role(UserRole.ROLE_USER).build();
			userRepository.save(user);
		}
		if (tourRepository.count()==0) {
			for (int i = 1; i < 39; i++) {
				LeagueTour tour= new LeagueTour();
				tour.setTourNumber(i);
				tourRepository.save(tour);
			}
		}
	if (matchRepository.count()==0) {
	for (int i = 1; i < 39; i++) {
			LeagueTour tour = new LeagueTour();
			tour.setId(i);
			tour.setTourNumber(i);
			for (int j = 1; j < 11; j++) {	
				Match match = new Match();
				match.setTour(tour);
				matchRepository.save(match);
			}
		}
		}
	
	if (teamRepository.count()==0) {
		BufferedReader inputStream = null;
      try {
            inputStream = new BufferedReader(new FileReader("src/main/resources/team.txt"));
            String str;
            while ((str = inputStream.readLine()) != null) {	
                String gerbUrl=str.substring(str.lastIndexOf(" "));
            	String str1=str.substring(0, str.lastIndexOf(" "));
            	String city=str1.substring(str1.lastIndexOf(" "));
            	String name=str.substring(0,str.lastIndexOf(city));
            	Team team= new Team();
            	team.setName(name);
            	team.setCity(city);
            	team.setMyGerb(gerbUrl);
            	teamRepository.save(team);
            }
        }
        catch (Exception e) {
			e.printStackTrace();
			System.out.println("weeeee");
		}
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
	}
	
	if (resultTeamRepository.count()==0) {
		List<Team> teams = teamRepository.findAll();
		Iterator<Team> teamIterator=teams.iterator();
		while (teamIterator.hasNext()) {
			Team team =teamIterator.next();
			ResultTeam resTeam = new ResultTeam();
			resTeam.setTeam(team);
			resultTeamRepository.save(resTeam);	
		}
	}
	if (playerRepository.count()==0) {
		for (int j = 0; j <4; j++) {
			Player player = new Player();
			player.setCountry("Egypt");
			player.setFullName("Mohamed Salah");
			player.setNumber(11);
			player.setImageUrl("https://res.cloudinary.com/dkhwkrdr9/image/upload/v1531083850/salah.jpg");
			player.setPosition("forward");
			playerRepository.save(player);
		}
	
		
	}
	
	}	
}
