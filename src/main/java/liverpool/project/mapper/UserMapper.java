package liverpool.project.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import liverpool.project.dto.UserDto;
import liverpool.project.entity.enums.UserRole;

public class UserMapper {
	


	public static User toSecurityUser(liverpool.project.entity.User user) {
		return new User(user.getLogin(), user.getPassword(),
				AuthorityUtils.createAuthorityList(String.valueOf(user.getRole())));
	}

	public static liverpool.project.entity.User convertToUser(UserDto userDTO) {
		return liverpool.project.entity.User.builder().login(userDTO.getLogin()).password(userDTO.getPassword())
				.email(userDTO.getEmail()).role(UserRole.ROLE_USER).build();
	}
	
	public static UserDto convertToUserDto(liverpool.project.entity.User user) {
		UserDto userDto= new UserDto();
		userDto.setLogin(user.getLogin());
		userDto.setEmail(user.getEmail());
		userDto.setRole(user.getRole());
		//userDto.setPassword(user.getPassword());
		return userDto;
	}
	


}
