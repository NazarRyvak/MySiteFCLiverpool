package liverpool.project.filter;

import lombok.Data;

@Data
public class CommodityFilter {
	
	/*private String TSHIRTS;
	private String SHORTS;
	private String SOCKS;
	private String SOUVENIRS;*/
	
	private String[] type;
	
	private String searchFromMinPrice;
	
	private String searchToMaxPrice;

}
