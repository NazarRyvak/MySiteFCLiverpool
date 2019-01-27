package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.LeagueTour;

public interface LeagueTourService {

	void saveTour(LeagueTour tour);
	
	LeagueTour findById(Integer id);
	
	List<LeagueTour> findAll();
	
	List<Integer> findAllNumberTour();
	
}
