package liverpool.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import liverpool.project.cloudinary.CloudinaryService;
import liverpool.project.entity.Commodity;
import liverpool.project.filter.CommodityFilter;
import liverpool.project.service.CommodityService;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@Autowired private CommodityService commodityService;
	@Autowired private CloudinaryService cloudinaryService;
	
	@GetMapping("/")
	public String showShop(Model model) {
		List<Commodity> commodities = commodityService.findAll();
		model.addAttribute("commodities", commodities);
		model.addAttribute("filter", new CommodityFilter());
		return "commodity";
	}
	@GetMapping("/search")
	public String showShopByFilter(Model model,@ModelAttribute("filter") CommodityFilter filter) {
		System.out.println(filter.getType().length);
		model.addAttribute("commodities", commodityService.findCommodityByFilter(filter));
		return "commodity";
	}
	
	@GetMapping("/add-commodity")
	public String AddCommodity(Model model) {
		model.addAttribute("commodityModel", new Commodity());
		return "add-commodity";
	}
	@PostMapping("/save-commodity")
	public String SaveCommodity(@ModelAttribute("commodityModel") Commodity commodity,@RequestParam("commodityImage") MultipartFile file){
		
		String imageUrl = cloudinaryService.uploadFile(file, "");
		commodity.setImageUrl(imageUrl);
		commodityService.save(commodity);
		return "redirect:/shop/";
	}
	
	
}
