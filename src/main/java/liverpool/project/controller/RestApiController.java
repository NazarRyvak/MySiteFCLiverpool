package liverpool.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import liverpool.project.cloudinary.CloudinaryService;
import liverpool.project.dto.PlayerDto;
import liverpool.project.entity.Player;
import liverpool.project.mapper.PlayerMapper;
import liverpool.project.service.PlayerService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	private PlayerService playerService;
	@Autowired
	private CloudinaryService cloudinaryService;

	@GetMapping("/players")
	public List<Player> findAll() {
		return playerService.findAll();
	}

	@PostMapping("/players/add")
	public ResponseEntity<Void> createPlayer(@RequestBody Player player) {
		playerService.save(player);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping(value = "/player/image/{playerId}", consumes = { "multipart/form-data" })
	public ResponseEntity<Void> uploadImage(@RequestParam("file") MultipartFile file,
			@PathVariable("playerId") int id) {
		System.out.println("asdfsdfasdf");
		String url = cloudinaryService.uploadFile(file, "");
		Player player = playerService.findById(id);
		player.setImageUrl(url);
		playerService.save(player);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/player/{playerId}")
	public PlayerDto findPlayerById(@PathVariable("playerId") int id) {
		System.out.println("sadf");
		Player player = playerService.findById(id);
		System.out.println(player);
		return PlayerMapper.convertToPlayerDto(player);
	}

	@PutMapping("/players/update/{playerId}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("playerId") int id, @RequestBody Player player) {

		Player playerFind = playerService.findById(id);
		if (playerFind != null) {
			player.setId(id);
			playerService.save(player);
		}
		return new ResponseEntity<Player>(player, HttpStatus.OK);
	}

	@DeleteMapping("/players/delete/{playerId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("playerId") int id) {
		System.out.println("asdfkjhsajdfhdsajfhsdf");
		playerService.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


}
