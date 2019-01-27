package liverpool.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerController {

	@GetMapping("/app/players")
	public String getFirstTeamPage() {
		return "first-team";
	}
	
}
