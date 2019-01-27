package liverpool.project.entity;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="league_tour")
@Data
public class LeagueTour extends BaseEntity {

	 @Column(name="tour_number", unique=true)
	private Integer tourNumber;
	
	@OneToMany(mappedBy="tour"/*,cascade=CascadeType.ALL*/)
	private List<Match> matches = new ArrayList<Match>();
	
/*	@Column(name="date_start")
	private LocalDate dateStart;
	
	@Column(name="date_finish")
	private LocalDate dateFinish;*/
	
}
