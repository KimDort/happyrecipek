package com.happyrecipek.web.cooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.happyrecipek.web.admin.repositories.ClassRepository;
import com.happyrecipek.web.admin.repositories.entities.ClassBase;

@Controller
public class CookingController {
	
	@Autowired
	private ClassRepository classRepository;
	
	@RequestMapping("/cooking/list")
	public String listPage() {
		return "web/pc/cooking/list";
	}
	
	/**
	 * @author KYJ
	 * @since 2019-01-03
	 * @param Device
	 * @return String Cooking Class Detail Page
	 */
	@RequestMapping("/cooking/detail")
	public @ResponseBody ClassBase classDetailPage(Integer classSeq) {
		ClassBase getDetail = new ClassBase();
		getDetail = classRepository.findByClassSeq(classSeq);
		return getDetail;
	}
}
