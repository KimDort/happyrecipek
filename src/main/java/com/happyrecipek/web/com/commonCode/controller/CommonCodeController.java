package com.happyrecipek.web.com.commonCode.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonCodeController {
	
	private static final Logger log = LogManager.getLogger(CommonCodeController.class);
	
	@RequestMapping("/common/code/create")
	public String codeCreatePage(Device device, Model model) {
		String returnPage="";
		
		if (device.isMobile()) {
			returnPage = "web/pc/common/code/create";
		} else if (device.isTablet()) {
			returnPage = "web/pc/common/code/create";
		} else if (device.isNormal()) {
			returnPage = "web/pc/common/code/create";
		}
		return returnPage;
	}
}
