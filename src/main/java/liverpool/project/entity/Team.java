package liverpool.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="team")
public class Team extends BaseEntity {

	private String name;
	
	private String city;
	
	@Column(name="my_gerb")
	private String myGerb;
	
	@OneToMany(mappedBy="homeTeamObject"/*,cascade=CascadeType.ALL*/)
	private List<Match> matchesHome = new ArrayList<Match>();
	
	@OneToMany(mappedBy="guestTeamObject"/*,cascade=CascadeType.ALL*/)
	private List<Match> matchesGuest = new ArrayList<Match>();
	
}
