package com.happyrecipek.web.member.controller.introduce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.member.controller.main.MainController;

@Controller
public class IntroduceController {
	private static final Logger log = LogManager.getLogger(MainController.class);

	@RequestMapping("/introduce")
	public String getIntroducePage(Device device) {
		String returnPage = "";

		if (device.isMobile()) {
			returnPage = "web/mobile/introduce/introduce";
		} else if (device.isTablet()) {
			returnPage = "web/mobile/introduce/introduce";
		} else if (device.isNormal()) {
			returnPage = "web/pc/introduce/introduce";
		}

		return returnPage;
	}
}
