package com.nunessports.repo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nunessports.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{
	Optional<Products> findProductsById(long id);
	Optional<Products> findProductsByName(String name);
	Optional<Products> deleteProductsById(long id);
	List<Products> findProductsByPriceBetween(BigDecimal lowest, BigDecimal highest);
	List<Optional<Products>> findProductsByNameAndPriceBetween(String name, BigDecimal lowest, BigDecimal highest );
}
