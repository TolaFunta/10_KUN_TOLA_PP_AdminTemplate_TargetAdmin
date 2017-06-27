package org.kshrd.template.controller;

import org.kshrd.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/home", "/admin"})
public class PageController {
	private UserService userService;

	@Autowired
	public PageController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping({"/", "/dashboard"})
	public String dashBoard(Model model) {
		model.addAttribute("LINK", "/dashboard");
		model.addAttribute("ACT_DASH", "active");
		model.addAttribute("MALE_TOTAL", userService.countTotal("m"));
		model.addAttribute("FEMALE_TOTAL", userService.countTotal("f"));
		model.addAttribute("TOTAL", userService.countTotal("%"));
		return "dashboard";
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
