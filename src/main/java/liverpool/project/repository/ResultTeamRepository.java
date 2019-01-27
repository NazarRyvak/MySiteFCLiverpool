package liverpool.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.ResultTeam;

@Repository
public interface ResultTeamRepository extends JpaRepository<ResultTeam, Integer> {
	@Query("select r from ResultTeam r order by point DESC, goalScore-goalMiss DESC, goalScore DESC ")
	List<ResultTeam> sorted();

}
