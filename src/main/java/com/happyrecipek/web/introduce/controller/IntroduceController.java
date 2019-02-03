package com.happyrecipek.web.introduce.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.main.controller.MainController;

@Controller
public class IntroduceController {
	private static final Logger log = LogManager.getLogger(MainController.class);

	@RequestMapping("/introduce")
	public String getIntroducePage(Device device) {
		String returnPage="";
		
		if(device.isMobile()) {
			returnPage = "web/mobile/introduce/main";
		}else if(device.isTablet()) {
			returnPage = "";
		}else if(device.isNormal()) {
			returnPage = "web/pc/introduce/main";
		}
		
		return returnPage;
	}
}
