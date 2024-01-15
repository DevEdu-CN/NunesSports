package com.nunessports.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nunessports.model.Products;
import com.nunessports.repo.ProductsRepository;

@Service
public class ProductsService {
	private final ProductsRepository productsRepository;
	
	public ProductsService(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	public Products addProducts(Products products) {
		return productsRepository.save(products);
	}
	
	public List<Products> findAllProducts() {
		return productsRepository.findAll();
	}
	
	public Optional<Products> findProductsById(long id) {
		return productsRepository.findById(id);
	}
	
	public Optional<Products> findProductsByName(String name) {
		return productsRepository.findProductsByName(name);
	}
	
	public List<Optional<Products>> findProductsByPrice(BigDecimal lowestPrice, BigDecimal highestPrice){
		return productsRepository
				.findProductsByPriceBetween(lowestPrice, highestPrice);
	}
	
	public void updateProducts(long id, Products updateProducts) {
		Products currentProducts = productsRepository.findById(id).get();
		currentProducts.setName(updateProducts.getName());
		currentProducts.setDescription(updateProducts.getDescription());
		currentProducts.setPrice(updateProducts.getPrice());
	}
	
	public void deleteProducts(long id) {
		productsRepository.deleteProductsById(id);
	
	}
	
	
}
