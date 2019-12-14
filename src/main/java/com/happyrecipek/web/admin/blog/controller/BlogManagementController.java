package com.happyrecipek.web.admin.blog.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happyrecipek.web.member.controller.blog.entities.Blog;
import com.happyrecipek.web.member.controller.blog.repositories.BlogRepository;

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
			returnPage = "web/pc/admin/blog/create";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/blog/create";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/blog/create";
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
		return "redirect:/admin/blog/blogListPage";
	}
	
	/**
	 * @author KYJ
	 * @since 2019-06-29
	 * @param Device
	 * @return String Blog List Page
	 */
	@RequestMapping("/admin/blog/blogListPage")
	public String blogListPage(Device device, Model model) {
		String returnPage = "";

		/**
		 * Selection blog List Repository
		 */
		List<Blog> resultList = blogRepository.findAll();

		model.addAttribute("blogList", resultList);

		if (device.isMobile()) {
			returnPage = "web/pc/admin/blog/list";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/blog/list";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/blog/list";
		}

		return returnPage;
	}
	
	/**
	 * @author KYJ
	 * @since 2019-06-29
	 * @param Device
	 * @return String Blog Detail Page Method
	 */
	@RequestMapping("/admin/blog/blogDetailPage")
	public String blogDetailPage(Device device, Model model, @RequestParam("seq") int seq) {
		String returnPage = "";

		Blog getBlogDetail = new Blog();
		getBlogDetail = blogRepository.findByBlogSeq(seq);
		model.addAttribute("getDetail", getBlogDetail);

		if (device.isMobile()) {
			returnPage = "web/pc/admin/blog/detail";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/blog/detail";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/blog/detail";
		}

		return returnPage;
	}
}
