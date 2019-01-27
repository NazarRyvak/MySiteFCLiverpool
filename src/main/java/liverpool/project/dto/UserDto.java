package liverpool.project.dto;

import javax.validation.constraints.NotEmpty;

import liverpool.project.entity.enums.UserRole;
import liverpool.project.validator.CheckIfUserEmailExist;
import liverpool.project.validator.CheckIfUserLoginExist;
import liverpool.project.validator.CheckPasswordMatch;
import lombok.Data;

@Data
@CheckPasswordMatch
public class UserDto {
	
	@CheckIfUserLoginExist
	@NotEmpty(message="The field login can`t be empty")
	private String login;
	
	@NotEmpty(message="The fieldemail can`t be empty")
	private String email;
	
	@NotEmpty(message="The field password can`t be empty")
	private String password;
	
	private String confirmPassword;
	
	private UserRole role;
	
}
