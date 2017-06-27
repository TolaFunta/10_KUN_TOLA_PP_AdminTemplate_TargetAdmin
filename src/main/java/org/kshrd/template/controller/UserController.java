package org.kshrd.template.controller;

import java.sql.Timestamp;

import org.kshrd.template.model.User;
import org.kshrd.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping({ "/user-cu" })
	public String createUser(Model model) {
		model.addAttribute("LINK", "/user/user-cu");
		model.addAttribute("ACT_USER", "active");
		model.addAttribute("USER", new User());
		return "user-create";
	}

	@RequestMapping({ "/update/{user_hash}" })
	public String updateUser(@PathVariable("user_hash") String user_hash, Model model, User user) {
		model.addAttribute("LINK", "/user/update/" + user_hash);
		model.addAttribute("ACT_USER", "active");
		model.addAttribute("USER", user = userService.findByUser_Hash(user_hash));
		this.setUser_hash(user_hash);
		return "user-update";
	}

	@RequestMapping({ "/user-list" })
	public String userList(Model model) {
		model.addAttribute("LINK", "/user/user-list");
		model.addAttribute("ACT_USER", "active");
		model.addAttribute("USERS", userService.findAll());
		// model.addAttribute("SAVE_MSG", this.message);
		return "user-list";
	}

	@RequestMapping({ "/user-profile/{user_hash}" })
	public String userProfile(@PathVariable("user_hash") String user_hash, Model model) {
		model.addAttribute("LINK", "/user/user-profile/" + user_hash);
		model.addAttribute("ACT_USER", "active");
		model.addAttribute("USER", userService.findByUser_Hash(user_hash));
		return "user-profile";
	}

	private String user_hash = "";

	public String getUser_hash() {
		return user_hash;
	}

	public void setUser_hash(String user_hash) {
		this.user_hash = user_hash;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute User user) {
		if (getUser_hash().equals("")) {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			user.setCreated_date(timestamp);
			userService.save(user);
			return "redirect:/user/user-cu/";
		} else {
			user.setUser_hash(user_hash);
			if (userService.updateByUserHash(user))
				System.out.println("Updated!");
			else
				System.out.println("Update failed!");
			setUser_hash("");
			return "redirect:/user/user-list";
		}
	}

	@RequestMapping({ "/delete/{user_hash}" })
	public String userDelete(@PathVariable("user_hash") String user_hash) {
		userService.deleteByUserHash(user_hash);
		return "redirect:/user/user-list";
	}

}
