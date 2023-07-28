package poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.AccountDTO;
import poly.ProductDTO;
import poly.model.Account;
import poly.model.Category;
import poly.model.Product;
import poly.service.AccountService;
import poly.service.CategoryService;
import poly.service.Paramservice;
import poly.service.ProductService;
import poly.service.SessionService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	public static String uploadAcc = System.getProperty("user.dir") + "/src/main/resources/static/accountImages";
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	@Autowired
	SessionService session;
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	AccountService accountService;
	@Autowired
	Paramservice paramservice;
	
//	View index
	@GetMapping("")
	public String adindex(){
		return "admin/adminHome";	
	}

// Star Account 

//  Views Account
	@GetMapping("accounts")
	public String viewAccount(Model model) {
		List<Account> ac = accountService.findAll();
		model.addAttribute("accounts", ac);
		return "admin/accounts";
	}

// 	Data account
	@GetMapping("account/add")
	public String getAccountAdd(Model model) {
		model.addAttribute("account", new Account());
		return "admin/accountAdd";
	}
	
// 	Add and Update Account
	@PostMapping("/account/add")
	public String postAccountAdd(@Validated @ModelAttribute("account")AccountDTO accountDTO,Errors result, BindingResult bindingResult ,Model model,
			@RequestParam("image")MultipartFile file)throws IOException {
		if (bindingResult.hasErrors() || result.hasErrors()|| file.isEmpty()) {
			model.addAttribute("ERROR_PHOTO","Please select a photo");
			return "admin/accountAdd";
		}
		Account account = new Account();
		account.setUsername(accountDTO.getUsername());
		account.setPassword(accountDTO.getPassword());
		account.setFullname(accountDTO.getFullname());
		account.setEmail(accountDTO.getEmail());
		account.setActivated(accountDTO.getActivated());
		account.setAdmin(accountDTO.getAdmin());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadAcc, imageUUID);
			Files.write(fileNameAndPath,file.getBytes());
		}else {
			imageUUID = null;
		}
		model.addAttribute("account", new AccountDTO());
		account.setPhoto(imageUUID);
		accountService.save(account);
		return"admin/accountAdd";
	}
//	Detele
	@GetMapping("/account/delete/{username}")
	public String deleteAccount(@PathVariable String username) {
		accountService.deleteById(username);
		return"redirect:/admin/accounts";
	}
//	Update
	@GetMapping("/account/update/{username}")
	public String updateAccountGet(@PathVariable String username, Model model) {
		Account account = accountService.findById(username).get();
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUsername(account.getUsername());
		accountDTO.setPassword(account.getPassword());
		accountDTO.setFullname(account.getFullname());
		accountDTO.setEmail(account.getEmail());
		accountDTO.setPhoto(account.getPhoto());
		accountDTO.setActivated(account.getActivated());
		accountDTO.setAdmin(account.getAdmin());
		model.addAttribute("account", accountDTO);		
		return"admin/accountAdd";
	}

// End Account
// Star Category
//	View Category
	@GetMapping("/categories")
	public String getCat(Model model){
		model.addAttribute("categories", categoryService.findAll());
		return "admin/categories";
	}
//  Get Add Category
	@GetMapping("/categorie/add")
	public String getCatAdd(Model model){
		model.addAttribute("category", new Category());
		return "admin/categoriesAdd";
	}
// 	Post Add Category
	@PostMapping("/categorie/add")
	public String postCatAdd(@ModelAttribute("category")Category category){
		categoryService.save(category);
		return "redirect:/admin/categories";
	}
// 	Delete Category
	@GetMapping("/categorie/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.deleteById(id);
		return"redirect:/admin/categories";
	}
// 	Update Category
	@GetMapping("/categorie/update/{id}")
	public String updateCat(@PathVariable int id,Model model) {
		Optional<Category> category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "admin/categoriesAdd";
	}
// End Category
// Star Product
	@GetMapping("/products")
    public String paginate(Model model, @RequestParam("ls") Optional<Integer> ls) {
        Pageable pageable = PageRequest.of(ls.orElse(1), 10);
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
        model.addAttribute("PAGE_NUMBERS", pageNumbers);

        return "admin/products";
    }
// 	Get Product Add
	@GetMapping("/product/add")
	public String productsadd(Model model){
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.findAll());
		return "admin/productsAdd";
	}	
// 	Post Product Add
	@PostMapping("/product/add")
	public String postProductAdd(@Validated @ModelAttribute("productDTO")ProductDTO productDTO,Errors result ,Model model,
			@RequestParam("productImage")MultipartFile file)throws IOException {
		if (result.hasErrors()|| file.isEmpty()) {
			model.addAttribute("ERROR_PHOTO","Please select a photo");
			return "admin/productsAdd";
		}
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setCreateDate(productDTO.getCreateDate());
		product.setCategory(productDTO.getCategory());	
		product.setAvailable(productDTO.getAvailable());
		product.setDescription(productDTO.getDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath,file.getBytes());
		}else {
			imageUUID = null;
		}
		model.addAttribute("productDTO", new ProductDTO());
		product.setImage(imageUUID);
		productService.save(product);
		return"admin/productsAdd";
	}
// 	Delete
	@GetMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteById(id);
		return"redirect:/admin/products";
	}
//	Update
	@GetMapping("/product/update/{id}")
	public String updateProductGet(@PathVariable int id, Model model) {
		Product product = productService.findById(id).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setCreateDate(product.getCreateDate());
//		productDTO.setCategory(product.getCategory());	
		productDTO.setAvailable(product.getAvailable());
		productDTO.setDescription(product.getDescription());		
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("productDTO", productDTO);
		return"admin/productsAdd";
	}
// End Product

}

