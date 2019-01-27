package liverpool.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	@Query("select t from Team t where t.name=:name")
	Team findTeamByName(@Param("name")String name);
}
