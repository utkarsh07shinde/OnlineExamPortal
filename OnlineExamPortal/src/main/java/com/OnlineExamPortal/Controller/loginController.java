package com.OnlineExamPortal.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OnlineExamPortal.entity.User;
import com.OnlineExamPortal.services.UserService;

@Controller
public class loginController {

	@Autowired
	private UserService userService;
	@GetMapping("/login")
	public String showLoginPage()
	{
		return "login";
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password)
	{
		User user = userService.findByUsername(username).orElse(null);
		
		if(user!=null && user.getPassword().equals(password))
		{
			return "home";
		}
		else {
			return "login";
		}
				
	}
	
}
