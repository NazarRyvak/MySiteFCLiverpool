package liverpool.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
