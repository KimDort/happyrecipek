package com.happyrecipek.web.cooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookingController {

	@RequestMapping("/cooking/list")
	public String listPage() {
		return "web/pc/cooking/list";
	}
}
