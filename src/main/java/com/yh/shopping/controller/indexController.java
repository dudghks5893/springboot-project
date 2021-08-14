package com.yh.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yh.shopping.service.admin.ProductsService;

@Controller
public class indexController {
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		model.addAttribute("products", productsService.상품목록(pageable));
		return "index";
	}
	
	@GetMapping("/products/{id}")
	public String findById(@PathVariable int id, Model model) {
		productsService.조회수증가(id);
		model.addAttribute("product", productsService.상품상세보기(id));
		return "admin/products/detail";
	}
	
}
