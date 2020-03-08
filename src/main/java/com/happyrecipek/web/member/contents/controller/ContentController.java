package com.happyrecipek.web.member.contents.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.com.commonCode.entities.CommonLowCode;
import com.happyrecipek.web.com.commonCode.repositories.CommonDetailCodeRepository;
import com.happyrecipek.web.member.contents.entities.Content;
import com.happyrecipek.web.member.contents.repositories.ContentRepository;

@Controller
public class ContentController {
	@Autowired
	private ContentRepository contentRepository;
	
	@Autowired
	private CommonDetailCodeRepository commonDetailCodeRepository;
	
	@RequestMapping("/content/{category}")
	public String contentPage(@PathVariable String category, Locale locale, Model model) {
		String returnPage = "web/pc/contents/list";
		String lang = locale.getLanguage().toUpperCase();
		
		List<Content> contensRow= new ArrayList<>();
		List<List<Content>> contensts= new ArrayList<>();
		CommonLowCode getCategoryNm = commonDetailCodeRepository.findByCommonLowCodeAndCommonLowCodeLocale(category, lang);
		
		long totalCount = contentRepository.countByCategoryLowCodeAndContentLocale(category, lang);
		
		int rows = (int) (totalCount / 6)==0?1:(int) (totalCount / 6);
		
		for(int i = 0; i < rows; i++) {
			Pageable pageable = PageRequest.of(i+1, 6, new Sort(Direction.DESC, "register_date"));
			contensRow = contentRepository.findByCategoryLowCodeAndContentLocale(category, lang);
			contensts.add(contensRow);
		}
		
		model.addAttribute("contensts", contensts);
		model.addAttribute("category", getCategoryNm);
		
		return returnPage;
	}
	
	@RequestMapping("/content/{category}/{contentId}")
	public String contentPage(@PathVariable String category, @PathVariable int contentId, Locale locale, Model model) {
		String returnPage = "web/pc/contents/content";
		String lang = locale.getLanguage().toUpperCase();
		Content content = contentRepository.findByCategoryLowCodeAndContentLocaleAndContentSeq(category, lang, contentId);
		
		model.addAttribute("content", content);
		
		return returnPage;
	}
	
}
