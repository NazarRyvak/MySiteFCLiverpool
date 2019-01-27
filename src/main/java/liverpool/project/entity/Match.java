package liverpool.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="matches")
public class Match extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name="home_team_object_id")
	private Team homeTeamObject;
	
	@ManyToOne 
	@JoinColumn(name="guest_team_object_id")
	private Team guestTeamObject;
	
	@Column(name="home_team")
	private String homeTeam;
	
	@Column(name="guest_team")
	private String guestTeam;
	
	@Column(name="goal_home")
	private Integer goalHome;
	
	@Column(name="goal_guest")
	private Integer goalGuest;
	
	@ManyToOne(/*cascade= {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH}*/)
	@JoinColumn(name="tour_id")
	private LeagueTour tour;
}
