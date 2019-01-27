package liverpool.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="player")
public class Player extends BaseEntity {

	@Column(name="full_name")
	private String fullName;
	
	private String position;
	
	private Integer number;
	
	private String country;
	
	private String description;
	
	@Column(name="image_url")
	private String imageUrl;
	
	
}
