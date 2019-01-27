package liverpool.project.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Position {

	GOALKEEPER("goalkeeper"),DEFENDER("defender"),MIDFIELDER("midfielder"),FORWARD("forward");
	
	private String pos;
	
}
