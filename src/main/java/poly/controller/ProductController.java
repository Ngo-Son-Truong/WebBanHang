package poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.model.Product;
import poly.service.ProductService;
import poly.service.SessionService;


@Controller

@RequestMapping("/product")
public class ProductController {
//	@Autowired
//	SessionService session;
//	@Autowired
//	ProductService service;
//	
//	@GetMapping("/views")
//	public String viewProduct(Model model,@RequestParam("field") Optional<String> field) {
//		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
//		List<Product> ls = service.findAll(sort);
//		model.addAttribute("LIST_PRODUCT", ls);
//		return "product";
//	}
//	
//	public boolean checkSecurity() {
//		String username = session.get("USERNAME");
//		System.err.println("checkSecurity "+username);
//		if (username != null) {
//			return true;
//		}
//		return false;
//	}
//	
//	@GetMapping("views/page")
//	public String paginate(Model model, @RequestParam("p")Optional<Integer> p) {
//		Pageable pageable = PageRequest.of(p.orElse(0), 6);
//		Page<Product> page = service.findAll(pageable);
//		model.addAttribute("LIST_PRODUCT", page);
//		return "product";
//	}
}
