package com.happyrecipek.web.member.controller.blog;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {

	@RequestMapping("/blog/list")
	public String listPage(Device device, Model model) {
		String returnPage = "";

		/**
		 * Selection Blog List Repository
		 */
		if (device.isMobile()) {
			returnPage = "web/mobile/blog/list";
		} else if (device.isTablet()) {
			returnPage = "web/mobile/blog/list";
		} else if (device.isNormal()) {
			returnPage = "web/pc/blog/list";
		}

		return returnPage;
	}
}
