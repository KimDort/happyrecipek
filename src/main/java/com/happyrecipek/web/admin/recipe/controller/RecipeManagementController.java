package com.happyrecipek.web.admin.recipe.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeManagementController {
	/**
	 * @author KYJ
	 * @since 2019-03-17
	 * @param Device
	 * @return String Recipe List Page
	 */
	@RequestMapping("/admin/recipe/recipeListPage")
	public String recipeListPage(Device device) {
		String returnPage = "";

		if (device.isMobile()) {
			returnPage = "web/pc/admin/recipe/list";
		} else if (device.isTablet()) {
			returnPage = "web/pc/admin/recipe/list";
		} else if (device.isNormal()) {
			returnPage = "web/pc/admin/recipe/list";
		}

		return returnPage;
	}
}
