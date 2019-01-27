package liverpool.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
	

	@Query("select m from Match m where m.homeTeam=:home and m.guestTeam=:guest")
	List<Match> findByTeams(@Param("home") String nameHome, @Param("guest") String nameGuest);
	
	@Query("select m from Match m where m.tour.tourNumber=:tour")
	List<Match> findByNumberTour(@Param("tour") Integer tour);
	
	@Query("select m from Match m where m.homeTeam=:name or m.guestTeam=:name")
	List<Match> findByNameTeam(@Param("name")String name);
	
}
