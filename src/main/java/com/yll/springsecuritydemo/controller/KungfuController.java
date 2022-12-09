package com.yll.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KungfuController {
	@GetMapping("/")
	public String index() {
		return "welcome";
	}

	@GetMapping("/userlogin")
	public String loginPage() {
		return "pages/login";
	}

	@GetMapping("/level1/{path}")
	public String level1(@PathVariable("path") String path) {
		return "pages/level1/" + path;
	}

	@GetMapping("/level2/{path}")
	public String level2(@PathVariable("path") String path) {
		return "pages/level2/" + path;
	}

	@GetMapping("/level3/{path}")
	public String level3(@PathVariable("path") String path) {
		return "pages/level3/" + path;
	}
}