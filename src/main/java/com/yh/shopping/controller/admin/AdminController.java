package com.yh.shopping.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/products/saveForm")
	public String saveForm() {
		return "/admin/products/saveForm";
	}
	
}
