package com.indra.formacio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterpriseController {

	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	
}
