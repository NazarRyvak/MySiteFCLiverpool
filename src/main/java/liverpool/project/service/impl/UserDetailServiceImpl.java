package liverpool.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import liverpool.project.entity.User;
import liverpool.project.mapper.UserMapper;
import liverpool.project.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		User user= userRepository.findUserByLogin(login);
		if (user==null) {
			throw new UsernameNotFoundException("User with login: "+login+" not found");
		}
		
		return UserMapper.toSecurityUser(user);
	}

}
