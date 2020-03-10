package com.happyrecipek.web.member.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.member.contents.entities.Content;
import com.happyrecipek.web.member.contents.repositories.ContentRepository;

@Controller
public class MainController {

	private static final Logger log = LogManager.getLogger(MainController.class);

	@Autowired
	private ContentRepository contentRepository;
	
	@RequestMapping(value = "/")
	public String mainPage(Device device, Model model, Locale locale) {
		String setReturn = "";
		
		String lang = locale.getLanguage().toUpperCase();
		String about = "CATEGORY_ABOUT";
		String cooking = "CATEGORY_COOK";
		String blog = "CATEGORY_BLOG";
		String product = "CATEGORY_PRODUCT";
		String media = "CATEGORY_MEDIA";
		
		List<Content> abouts = new ArrayList<>();
		List<Content> cookings = new ArrayList<>();
		List<Content> blogs = new ArrayList<>();
		List<Content> products = new ArrayList<>();
		List<Content> medium = new ArrayList<>();
		
		Pageable pageable = PageRequest.of(0, 6, new Sort(Direction.DESC, "registerDate"));
		abouts = contentRepository.findByCategoryLowCodeAndContentLocale(about, lang, pageable);
		cookings = contentRepository.findByCategoryLowCodeAndContentLocale(cooking, lang, pageable);
		blogs = contentRepository.findByCategoryLowCodeAndContentLocale(blog, lang, pageable);
		products = contentRepository.findByCategoryLowCodeAndContentLocale(product, lang, pageable);
		medium = contentRepository.findByCategoryLowCodeAndContentLocale(media, lang, pageable);
		
		if (device.isMobile()) {
			setReturn = "web/pc/index";
		} else if (device.isTablet()) {
			setReturn = "web/pc/index";
		} else if (device.isNormal()) {
			setReturn = "web/pc/index";
		}
		
		model.addAttribute("abouts", abouts);
		model.addAttribute("cookings", cookings);
		model.addAttribute("blogs", blogs);
		model.addAttribute("products", products);
		model.addAttribute("medium", medium);
		
		return setReturn;
	}
}
