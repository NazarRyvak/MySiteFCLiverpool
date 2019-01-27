package liverpool.project.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import liverpool.project.entity.Commodity;
import liverpool.project.filter.CommodityFilter;
import liverpool.project.repository.CommodityRepository;
import liverpool.project.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityRepository commodityRepository;

	@Override
	public void save(Commodity commodity) {
		commodityRepository.save(commodity);
	}

	@Override
	public Commodity findById(Integer id) {
		return commodityRepository.getOne(id);
	}

	@Override
	public List<Commodity> findAll() {
		return commodityRepository.findAll();
	}

	@Override
	public List<Commodity> findByType(String type) {
		return commodityRepository.findByType(type);
	}

	@Override
	public List<Commodity> findCommodityByFilter(CommodityFilter filter) {
		return commodityRepository.findAll(getSpecification(filter));
	}
	
	private Specification<Commodity> getSpecification(CommodityFilter filter){
		
		return new Specification<Commodity>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Commodity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				/*Predicate[] predicate=new Predicate[filter.getType().length];*/
				Predicate type=null;
				if (filter.getType().length>0) {
					 type = root.get("type").in(filter.getType());
				}
				Predicate price = null;
				
	/*			for (int i = 0; i < predicate.length; i++) {
					predicate[i]=criteriaBuilder.equal(root.get("type"), filter.getType()[i]);
					System.out.println("Predicate:"+ predicate[i]);
					
				}*/
				int min=0;
				int max=Integer.MAX_VALUE;
				
				query.orderBy(criteriaBuilder.asc(root.get("price")));
				if (!filter.getSearchFromMinPrice().equals("") && !filter.getSearchToMaxPrice().equals("")) {
					min = Integer.parseInt(filter.getSearchFromMinPrice());
					max = Integer.parseInt(filter.getSearchToMaxPrice());
				} else if (filter.getSearchFromMinPrice().equals("") && !filter.getSearchToMaxPrice().equals("")) {
					min = 0;
					max = Integer.parseInt(filter.getSearchToMaxPrice());
				} else if (filter.getSearchToMaxPrice().equals("") && !filter.getSearchFromMinPrice().equals("")) {
					min = Integer.parseInt(filter.getSearchFromMinPrice());
					max = Integer.MAX_VALUE;
				}
				price = criteriaBuilder.between(root.get("price"), min, max);
				query.orderBy(criteriaBuilder.asc(root.get("id")));
				
				if (filter.getType().length>0) {
					return criteriaBuilder.and(type, price);
				}else {
					return criteriaBuilder.and(price);
				}	
				
			}
		};
		
	}

}
