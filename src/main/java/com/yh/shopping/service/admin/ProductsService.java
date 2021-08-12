package com.yh.shopping.service.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yh.shopping.model.User;
import com.yh.shopping.model.admin.Products;
import com.yh.shopping.repository.admin.ProductsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService {
	
	private final ProductsRepository productsRepository;
	
	@Transactional
	public void 상품등록(Products products, User user) {
		products.setHit(0);
		products.setUser(user);
		productsRepository.save(products);
	}
	
	@Transactional(readOnly = true)
	public Page<Products> 상품목록(Pageable pageable){
		return productsRepository.findAll(pageable);
	}
	
	@Transactional
	public int 조회수증가(int id){
		return productsRepository.updateHit(id);
	}
	
	@Transactional(readOnly = true)
	public Products 상품상세보기(int id){
		Products products = productsRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("상품 상세보기 실패 : 아이디를 찾을 수 없습니다.");
				});
		return products;
	}
	
	@Transactional
	public void 상품삭제(int id) {
		productsRepository.deleteById(id);
	}
	
	@Transactional
	public void 상품수정(int id, Products reqProducts) {
		Products products = productsRepository.findById(id)
			.orElseThrow(()->{
				return new IllegalArgumentException("상품 수정 실패 : 아이디를 찾을 수 없습니다.");
			});
		products.setProductName(reqProducts.getProductName());
		products.setContent(reqProducts.getContent());
		products.setPrice(reqProducts.getPrice());
		products.setStock(reqProducts.getStock());
	}
	
	
}
