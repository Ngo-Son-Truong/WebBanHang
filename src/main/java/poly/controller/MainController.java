package poly.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import poly.model.Product;
import poly.service.CategoryService;
import poly.service.ProductService;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;

	@GetMapping("/home")
    public String paginate(Model model, @RequestParam("ls") Optional<Integer> ls,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			Pageable pageable = PageRequest.of(ls.orElse(1), 12);
	        Page<Product> page = productService.findAll(pageable);
	        model.addAttribute("products", page);

	        int currentPage = page.getNumber();
	        int totalPages = page.getTotalPages();
	        List<Integer> pageNumbers = new ArrayList<>();
	        if (currentPage > 1) {
	            pageNumbers.add(currentPage - 1);
	        }
	        pageNumbers.add(currentPage);
	        if (currentPage < totalPages - 1) {
	            pageNumbers.add(currentPage + 1);
	        }
	        if (currentPage < totalPages - 2) {
	            pageNumbers.add(currentPage + 2);
	        }
	        model.addAttribute("categories", categoryService.findAll());
	        model.addAttribute("PAGE_NUMBERS", pageNumbers);

	        return "index";
		}
		return "login";
    }
	
	@GetMapping("prodetail")
	public String prodetail(HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			return "prodetail";
		}
		return "login";			
	}
	
	@GetMapping("contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable int id,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("product", productService.findById(id).get());
			return "viewProduct";
		}
		return "login";		
	}
	
	@GetMapping("/addcart/{id}")
	public String addcart(Model model,@PathVariable int id,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			model.addAttribute("product", productService.findById(id).get());
			return "cart";
		}
		return "login";		
	}
	
	@GetMapping({"shop"})
	public String listproduct(Model model, @RequestParam("ls") Optional<Integer> ls,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			Pageable pageable = PageRequest.of(ls.orElse(1), 12);
	        Page<Product> page = productService.findAll(pageable);
	        model.addAttribute("products", page);

	        int currentPage = page.getNumber();
	        int totalPages = page.getTotalPages();
	        List<Integer> pageNumbers = new ArrayList<>();
	        if (currentPage > 1) {
	            pageNumbers.add(currentPage - 1);
	        }
	        pageNumbers.add(currentPage);
	        if (currentPage < totalPages - 1) {
	            pageNumbers.add(currentPage + 1);
	        }
	        if (currentPage < totalPages - 2) {
	            pageNumbers.add(currentPage + 2);
	        }
	        model.addAttribute("categories", categoryService.findAll());
	        model.addAttribute("PAGE_NUMBERS", pageNumbers);

	        return "listproduct";
		}
		return "login";	
		
	}
	
	@GetMapping("/shop/{id}")
	public String shopByCategory(Model model,@PathVariable int id,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("products", productService.getAllProductsByCategoryId(id));
			return "listproduct";
		}
		return "login";	
		
	}
	
	@GetMapping("cart")
	public String cart(Model model,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {			
			model.addAttribute("categories", categoryService.findAll());
			return "cart";
		}
		return "login";
	}
	@GetMapping("checkout")
	public String checkout(Model model,HttpSession httpSession) {
		if (httpSession.getAttribute("username") != null) {
			model.addAttribute("categories", categoryService.findAll());
			return "checkout";
		}
		return "login";	
	}
}
