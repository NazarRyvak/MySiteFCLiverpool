package liverpool.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liverpool.project.entity.Player;
import liverpool.project.repository.PlayerRepository;
import liverpool.project.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired private PlayerRepository playerRepository;
	
	@Override
	public Player findById(int id) {
		return playerRepository.getOne(id);
	}

	@Override
	public void save(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public void update(Player player) {
		playerRepository.save(player);
		
	}

	@Override
	public List<Player> findAll() {
	
		return playerRepository.findAll();
	}

	@Override
	public void deleteById(int id) {
		playerRepository.deleteById(id);
	}

}
