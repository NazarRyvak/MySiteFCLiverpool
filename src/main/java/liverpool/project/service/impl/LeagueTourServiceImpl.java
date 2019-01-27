package liverpool.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liverpool.project.entity.LeagueTour;
import liverpool.project.repository.LeagueTourRepository;
import liverpool.project.service.LeagueTourService;

@Service
public class LeagueTourServiceImpl implements LeagueTourService {

	@Autowired LeagueTourRepository tourRepository;
	@Override
	public void saveTour(LeagueTour tour) {
		tourRepository.save(tour);
	}

	@Override
	public LeagueTour findById(Integer id) {
		return tourRepository.getOne(id);
	}

	@Override
	public List<LeagueTour> findAll() {
		return tourRepository.findAll();
	}

	@Override
	public List<Integer> findAllNumberTour() {
		return tourRepository.findAllNumberTour();
	}

}
