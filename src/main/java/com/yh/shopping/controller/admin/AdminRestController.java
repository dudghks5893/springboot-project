package com.yh.shopping.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yh.shopping.config.auth.PrincipalDetails;
import com.yh.shopping.dto.ResponseDto;
import com.yh.shopping.model.admin.Products;
import com.yh.shopping.service.admin.ProductsService;

@RestController
public class AdminRestController {
	
	@Autowired
	private ProductsService productsService;
	
	@PostMapping("/rest/products")
	public ResponseDto<Integer> save(@RequestBody Products products, @AuthenticationPrincipal PrincipalDetails principal){
		productsService.상품등록(products, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
}
