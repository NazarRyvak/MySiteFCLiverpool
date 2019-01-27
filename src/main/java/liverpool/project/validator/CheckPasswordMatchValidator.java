package liverpool.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import liverpool.project.dto.UserDto;


@Component
public class CheckPasswordMatchValidator 
	implements ConstraintValidator<CheckPasswordMatch,UserDto> {
	@Override
	public boolean isValid(UserDto userDto, ConstraintValidatorContext arg1) {
		if(userDto.getPassword() == " " || userDto.getConfirmPassword() == " ") {
			return false;
		}
		if(userDto.getPassword().equals(userDto.getConfirmPassword())) {
			return true;
		}
		return false;
	}	
}