package liverpool.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.LeagueTour;

@Repository
public interface LeagueTourRepository extends JpaRepository<LeagueTour, Integer>{

	@Query("select t.tourNumber from LeagueTour t")
	List<Integer> findAllNumberTour();
}
