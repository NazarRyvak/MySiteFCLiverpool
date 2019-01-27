package liverpool.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	@GetMapping("/403")
	public String show403() {
		return "403";
	}
	
}
