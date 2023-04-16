package com.midterm.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.midterm.entities.User;

@Controller
public class UserController {

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "login";
	}
	
	@GetMapping("/register")
	public String registerForm(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "register";
		} else {
			return "profile";
		}
	}

	@PostMapping("/register")
	public RedirectView registerUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/login");
		return redirectView;
	}

	@GetMapping("/login")
	public String loginForm(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		} else {
			return "profile";
		}
	}

	@PostMapping("/login")
	public RedirectView loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
	        HttpServletRequest request) {
	    RedirectView redirectView = new RedirectView();
	    if ("chen@humber.com".equals(email) && "password123".equals(password)) {
	        User user = new User();
	        user.setEmail(email);
	        user.setName("Junzhi Chen");
	        user.setGender("male");
	        request.getSession().setAttribute("user", user);
	        redirectView.setUrl(request.getContextPath() + "/profile");
	    } else {
	        redirectView.setUrl(request.getContextPath() + "/login");
	    }
	    return redirectView;
	}


	@GetMapping("/profile")
	public String profile(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		
		return "profile";
	}
}
