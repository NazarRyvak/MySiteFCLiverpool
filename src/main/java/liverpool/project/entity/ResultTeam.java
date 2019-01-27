package liverpool.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="result_team")
public class ResultTeam extends BaseEntity{

	@OneToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	private Integer game;
	
	@Column(name="game_win")
	private Integer gameWin;
	
	@Column(name="game_draw")
	private Integer gameDraw;
	
	@Column(name="game_lose")
	private Integer gameLose;
	
	@Column(name="goal_score")
	private Integer goalScore;
	
	@Column(name="goal_miss")
	private Integer goalMiss;
	
	private Integer point;
	
	}

