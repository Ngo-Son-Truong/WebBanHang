package poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import poly.AccountDTO;
import poly.model.Account;
import poly.service.AccountService;

@Controller
public class Login_Register {
	public static String uploadAcc = System.getProperty("user.dir") + "/src/main/resources/static/accountImages";
	@Autowired
	AccountService accountService;
// 	Login
	@RequestMapping("login")
	public String Showlogin() {
		return "login";
	}
	
	@PostMapping("login")
	public String checklogin(Model model,@RequestParam("username")String username,@RequestParam("password")String password,
			HttpSession session,String ho,String ten) {
		if (accountService.checklogin(username, password)) {
			session.setAttribute("fullname", accountService.findById(username).get().getFullname());
			session.setAttribute("username", accountService.findById(username).get().getUsername());
			session.setAttribute("email", accountService.findById(username).get().getEmail());
			System.out.println("Login Thành Công");
			return "redirect:/home?ls=0";
		}else {
			System.out.println("login Thất Bại");
			model.addAttribute("error", "Email Hoặc Password không đúng vui lòng thử lại!");
		}
		return "login";
	}
//	Logout
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return"redirect:/login";
	}
//	Register 
	@RequestMapping("register")
	public String register(Model model){
		model.addAttribute("account", new Account());
		return "register";
	}
	@PostMapping("/register")
	public String postAccountAdd(@ModelAttribute("account")AccountDTO accountDTO,
			@RequestParam("accountimg")MultipartFile file)throws IOException {
		Account account = new Account();
		account.setAdmin(accountDTO.getAdmin());
		account.setUsername(accountDTO.getUsername());
		account.setEmail(accountDTO.getEmail());
		account.setPassword(accountDTO.getPassword());
		account.setFullname(accountDTO.getFullname());
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
		account.setPhoto(imageUUID);
		accountService.save(account);
		return"redirect:/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
