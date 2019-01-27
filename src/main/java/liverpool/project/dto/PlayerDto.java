package liverpool.project.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PlayerDto {
	
	private Integer id;
	
	private String fullName;
	
	private String position;
	
	private Integer number;
	
	private String country;
	
	private String description;
	
	private String imageUrl;
}
