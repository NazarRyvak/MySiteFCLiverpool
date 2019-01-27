package liverpool.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import liverpool.project.entity.User;
import liverpool.project.mail.Mail;
import liverpool.project.repository.UserRepository;
import liverpool.project.service.EmailService;
import liverpool.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired private EmailService emailService;

	@Override
	public void save(User user) {
		Mail mail = new Mail();
		mail.setTo(user.getEmail());
		mail.setSubject("Test Registration");
		mail.setMessage("Test message");
		emailService.sendMessage(mail);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findUserByLogin(login);
	}

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

}
