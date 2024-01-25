package com.nunessports.repo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nunessports.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	Page<Products> findProductsByName(String name, Pageable pageable);
	
	Optional<Products> deleteProductsById(long id);
	Page<Products> findProductsByPriceBetween(BigDecimal lowest, 
			BigDecimal highest, Pageable pageable);
	Page<Products> findProductsByNameAndPriceBetween(
			String name, 
			BigDecimal lowest, 
			BigDecimal highest, 
			Pageable pageable);
}
