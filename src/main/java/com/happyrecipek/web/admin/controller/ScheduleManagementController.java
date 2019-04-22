package com.happyrecipek.web.admin.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScheduleManagementController {

	/**
	 * @author KYJ
	 * @since 2019-03-17
	 * @param Device
	 * @return String Schedule List Page
	 */
	@RequestMapping("/admin/schedule/scheduleListPage")
	public String scheduleListPage(Device device, Model model) {
		String returnPage = "";
		
		if (device.isMobile()) {
			returnPage = "web/pc/admin/schedule/list";
		} 
		//else if (device.isTablet()) {returnPage = "";} 
		else if (device.isNormal()) {
			returnPage = "web/pc/admin/schedule/list";
		}
		
		return returnPage;
	}
}
