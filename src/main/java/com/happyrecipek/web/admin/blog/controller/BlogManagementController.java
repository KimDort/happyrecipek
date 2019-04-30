package com.happyrecipek.web.admin.blog.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.member.entities.Blog;
import com.happyrecipek.web.member.repositories.BlogRepository;

@Controller
public class BlogManagementController {

	private static final Logger log = LogManager.getLogger(BlogManagementController.class);
	
	@Autowired
	private BlogRepository blogRepository;
	
	/**
	 * @author KYJ
	 * @since 2019-04-24
	 * @param Device
	 * @return String
	 */
	@RequestMapping("/admin/blog/create")
	public String createPage(Device device, Model model) {
		String returnPage = "";
		
		if (device.isMobile()) {
			returnPage = "web/mobile/blog/create";
		} else if (device.isTablet()) {
			returnPage = "web/mobile/blog/create";
		} else if (device.isNormal()) {
			returnPage = "web/pc/blog/create";
		}

		return returnPage;
	}
	
	/**
	 * @author KYJ
	 * @since 2019-04-22
	 * @param Device
	 * @return String
	 */
	@RequestMapping("/admin/blog/createProc")
	public String createProc(@ModelAttribute("blog") Blog blog) {
		blogRepository.save(blog);
		return "redirect:/blog/list";
	}
}
