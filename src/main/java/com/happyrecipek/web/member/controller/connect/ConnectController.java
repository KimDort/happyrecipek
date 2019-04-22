package com.happyrecipek.web.member.controller.connect;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnectController {
	
	@RequestMapping("/connect")
	public String mainPage(Device device, Model model) {
		String returnPage = "";

		/**
		 * Selection connect Main Repository
		 */
		if (device.isMobile()) {
			returnPage = "web/mobile/connect/index";
		} else if (device.isTablet()) {
			returnPage = "web/mobile/connect/index";
		} else if (device.isNormal()) {
			returnPage = "web/pc/connect/index";
		}

		return returnPage;
	}
}
