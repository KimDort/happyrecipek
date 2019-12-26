package com.happyrecipek.web.admin.contents.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentManagementController {
	
	@RequestMapping("/admin/content/addContentPage")
	public String addContentPage(Device device) {
		String returnPage="";
		
		if (device.isMobile()) {
			returnPage = "web/pc/admin/content/addContent";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/content/addContent";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/content/addContent";
		}
		return returnPage;
	}
}
