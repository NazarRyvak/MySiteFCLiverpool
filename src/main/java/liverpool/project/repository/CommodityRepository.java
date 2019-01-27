package liverpool.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import liverpool.project.entity.Commodity;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, Integer>, JpaSpecificationExecutor<Commodity> {

	@Query("select c from Commodity c where c.type=:type")
	List<Commodity> findByType(@Param("type")String type);
	
}
