package com.yh.shopping.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yh.shopping.model.admin.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{
	
	@Modifying
	@Query(value="update products set hit = hit+1 where id = ? ", nativeQuery = true)
	int updateHit(int id);
}
