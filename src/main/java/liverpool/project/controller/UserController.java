package liverpool.project.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import liverpool.project.cloudinary.CloudinaryService;
import liverpool.project.dto.UserDto;
import liverpool.project.entity.User;
import liverpool.project.mapper.UserMapper;
import liverpool.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired private UserService userService;
	@Autowired private CloudinaryService cloudinaryService;
	
	@GetMapping("/profile/{username}")
	public String showProfileAdmin(@PathVariable String username ,Principal principal, Model model) {
		User user =userService.findUserByLogin(principal.getName()) ;
		model.addAttribute("userModel", user);
		return "userProfile";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login-form";
	}
	
	@GetMapping("/register")
	public String showRegistry(Model model) {
		model.addAttribute("registerModel", new UserDto());
		return "register-form";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerModel") UserDto userDTO,BindingResult br) {
		if (br.hasErrors()) {
			return "register-form";
		}
		userService.save(UserMapper.convertToUser(userDTO));
		return "redirect:/";
	}
	@GetMapping("/{userId}/image")
	public String showUploadImage(@PathVariable int userId, Model model) {
		model.addAttribute("userId", userId);
		return "upload";
	}
	

	@PostMapping("/image/upload")
	public String uploadImage(@RequestParam("user_id") String userIdStr, @RequestParam("profileImage") MultipartFile file) {
		User user=userService.findById(Integer.valueOf(userIdStr));
		String imageUrl = cloudinaryService.uploadFile(file, "");
		user.setProfileImageUrl(imageUrl);
		userService.update(user);
		return "redirect:/user/profile/"+user.getLogin();
	}
	
}
