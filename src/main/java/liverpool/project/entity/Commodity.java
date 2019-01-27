package liverpool.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="commodity")
public class Commodity extends BaseEntity{
	
	private String type;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column( length = 5000)
	private String description;
	
	private Double price;
	
	private String name;

}
