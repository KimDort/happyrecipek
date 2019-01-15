package com.happyrecipek.web.main.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.site.SitePreference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger log = LogManager.getLogger(MainController.class);
	
	@RequestMapping(value="/")
	public String mainPage(Device device) {
		String setReturn="";
		
		if(device.isMobile()) {
			setReturn = "web/mobile/index";
		}else if(device.isTablet()) {
			setReturn = "";
		}else if(device.isNormal()) {
			setReturn="web/pc/index";
		}
		
		return setReturn;
	}
}
