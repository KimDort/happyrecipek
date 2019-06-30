package com.happyrecipek.web.member.controller.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.happyrecipek.web.member.entities.Blog;
import com.happyrecipek.web.member.repositories.BlogRepository;

@Controller
public class BlogController {

	@Autowired
	private BlogRepository blogRepository;
	
	/**
	 * @author KYJ
	 * @since 2019-04-22
	 * @param Device, Model, Pageable
	 * @return String
	 */
	@RequestMapping("/blog/list")
	public String listPage(Device device, Model model, Pageable pageable) {
		String returnPage = "";
		int page = (pageable.getPageNumber() == 0)? 0 : (pageable.getPageNumber() - 1);
		pageable = PageRequest.of(page, 5);
		Page<Blog> getList = blogRepository.findAllByDisplayYnOrderByRegisterDateDesc("Y", pageable);
		
		model.addAttribute("list",getList);
		
		if (device.isMobile()) {
			returnPage = "web/pc/blog/list";
		} else if (device.isTablet()) {
			returnPage = "web/pc/blog/list";
		} else if (device.isNormal()) {
			returnPage = "web/pc/blog/list";
		}

		return returnPage;
	}
	
}
