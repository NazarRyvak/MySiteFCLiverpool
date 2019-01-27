package liverpool.project.service;

import java.util.List;

import liverpool.project.entity.Commodity;
import liverpool.project.filter.CommodityFilter;

public interface CommodityService {
	
	void save(Commodity commodity);
	
	Commodity findById(Integer id);
	
	List<Commodity> findAll();
	
	List<Commodity> findByType(String type);

	List<Commodity> findCommodityByFilter(CommodityFilter filter);
}
