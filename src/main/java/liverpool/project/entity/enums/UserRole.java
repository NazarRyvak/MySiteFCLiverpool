package liverpool.project.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {

	ROLE_USER("USER"), ROLE_ADMIN("ADMIN");
	
	private String myRole;
}
