package com.yh.shopping.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yh.shopping.model.admin.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
