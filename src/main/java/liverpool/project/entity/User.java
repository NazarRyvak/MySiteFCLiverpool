package liverpool.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;

import liverpool.project.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="user",indexes= @Index(columnList="login"))
public class User extends BaseEntity{

	private String login;
	
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	private String token;
	
	@Column(name="profile_image_url", length=500)
	private String profileImageUrl;
	
}
