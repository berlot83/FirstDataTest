package com.firstdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
 * Author Axel Berlot 2019/06/09
 * berlot83@yahoo.com.ar
 */

@Controller
public class NavigationControllers {

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/index")
	public String indexAlternative() {
		return "index";
	}
	
}
