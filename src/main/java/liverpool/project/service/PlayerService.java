package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.Player;

public interface PlayerService {
	
	Player findById(int id);
	
	void save(Player player);
	
	void update(Player player);
	
	List<Player> findAll();
	
	void deleteById(int id);

}
