package org.kshrd.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping({"/", "/home", "/dashboard"})
	public String dashBoard(Model model) {
		model.addAttribute("LINK", "/dashboard");
		model.addAttribute("ACT_DASH", "active");
		return "dashboard";
	}
	
	@RequestMapping({"/user-cu"})
	public String userCU(Model model) {
		model.addAttribute("LINK", "/user-cu");
		model.addAttribute("ACT_USER", "active");
		return "user-cu";
	}
	
	@RequestMapping({"/user-list"})
	public String userList(Model model) {
		model.addAttribute("LINK", "/user-list");
		model.addAttribute("ACT_USER", "active");
		return "user-list";
	}

	@RequestMapping({"/user-profile"})
	public String userProfile(Model model) {
		model.addAttribute("LINK", "/user-profile");
		model.addAttribute("ACT_USER", "active");
		return "user-profile";
	}
	
	@RequestMapping({"/role-cu"})
	public String roleCU(Model model) {
		model.addAttribute("LINK", "/role-cu");
		model.addAttribute("ACT_ROLE", "active");
		return "role-cu";
	}
	
	@RequestMapping({"/role-list"})
	public String roleList(Model model) {
		model.addAttribute("LINK", "/role-list");
		model.addAttribute("ACT_ROLE", "active");
		return "role-list";
	}
}
