package liverpool.project.mapper;

import liverpool.project.dto.PlayerDto;
import liverpool.project.entity.Player;

public class PlayerMapper {

	public static Player convertToPlayer(PlayerDto playerDto) {
		Player player = new Player();
		player.setId(playerDto.getId());
		player.setFullName(playerDto.getFullName());
		player.setCountry(playerDto.getCountry());
		player.setDescription(playerDto.getDescription());
		player.setNumber(playerDto.getNumber());
		player.setPosition(playerDto.getPosition());
		return player;
		
	}
	
	public static PlayerDto convertToPlayerDto(Player player) {
		PlayerDto playerDto= new PlayerDto();
		playerDto.setId(player.getId());
		playerDto.setFullName(player.getFullName());
		playerDto.setCountry(player.getCountry());
		playerDto.setDescription(player.getDescription());
		playerDto.setImageUrl(player.getImageUrl());
		playerDto.setNumber(player.getNumber());
		playerDto.setPosition(player.getPosition());
		
		return playerDto;
	}
}
