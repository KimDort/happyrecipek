package com.happyrecipek.web.com.commonCode.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.com.commonCode.entities.CommonHighCode;
import com.happyrecipek.web.com.commonCode.repositories.CommonCodeRepository;

@Controller
public class CommonCodeController {
	
	private static final Logger log = LogManager.getLogger(CommonCodeController.class);
	
	@Autowired
	private CommonCodeRepository commonCodeRepository;
	
	@RequestMapping("/common/code/create")
	public String codeCreatePage(Device device, Model model, Locale locale) {
		String returnPage="";
		String lang = locale.getLanguage().toUpperCase();
		CommonHighCode languageCode = new CommonHighCode();
		List<CommonHighCode> highCodes = new ArrayList<>();
		
		highCodes = commonCodeRepository.findByCommonHighCodeLocale(lang);
		
		if(lang.equals("KO")) {
			languageCode = commonCodeRepository.findByCommonHighCode("COMMLOC001");
		}else if(lang.equals("JA")) {
			languageCode = commonCodeRepository.findByCommonHighCode("COMMLOC002");
		}else if(lang.equals("EN")) {
			languageCode = commonCodeRepository.findByCommonHighCode("COMMLOC003");
		}
		
		log.info("[LOGGER] ===== Code Create Page Controlle");
		log.info("[LOGGER] ===== Locale {}", locale);
		log.info("[LOGGER] ===== Code List {}", highCodes);
		
		model.addAttribute("codeList", highCodes);
		model.addAttribute("languageCode", languageCode);
		
		if (device.isMobile()) {
			returnPage = "web/pc/common/code/create";
		} else if (device.isTablet()) {
			returnPage = "web/pc/common/code/create";
		} else if (device.isNormal()) {
			returnPage = "web/pc/common/code/create";
		}
		return returnPage;
	}
	
	@RequestMapping("/common/code/createProc")
	public String codeCreatePageProc(@ModelAttribute("commonCode")CommonHighCode commonCode) {
		commonCodeRepository.save(commonCode);
		log.debug("common code insert {}", commonCode);
		
		return "redirect:/common/code/create";
	}
}
