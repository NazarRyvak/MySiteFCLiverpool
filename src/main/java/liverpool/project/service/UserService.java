package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.User;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	List<User> findAll();
	
	User findUserByLogin(String login);
	
	void update(User user);
}
