package com.happyrecipek.web.member.contents.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
	
	@RequestMapping("/content/{category}/{contentId}")
	public String contentPage(@PathVariable String category
			, @PathVariable String contentId
			, Locale locale) {
		String returnPage = "web/pc/contents/content";
		System.out.println("content category : "+category+", id : "+contentId);
		String lang = locale.getLanguage().toUpperCase();
		System.out.println("get header : "+lang);
		return returnPage;
	}
}
