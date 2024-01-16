package com.nunessports.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nunessports.exception.userNotFoundException;
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
	
	public Products findProductsById(long id) {
		return productsRepository.findById(id)
				.orElseThrow(() -> new userNotFoundException("Product by Id " + id + " was not found."));
	}
	
	public Products findProductsByName(String name) {
		return productsRepository.findProductsByName(name)
				.orElseThrow(() -> new userNotFoundException("Product by name " + name + " was not found."));
	}
	
	public List<Products> findProductsByPrice(BigDecimal lowestPrice, BigDecimal highestPrice){
		return productsRepository
				.findProductsByPriceBetween(lowestPrice, highestPrice);
	}
	
	public Products updateProducts(long id, Products updateProducts) {
		Products currentProducts = productsRepository.findById(id).get();
		currentProducts.setName(updateProducts.getName());
		currentProducts.setDescription(updateProducts.getDescription());
		currentProducts.setPrice(updateProducts.getPrice());
		return currentProducts;
	}
	
	public void deleteProducts(long id) {
		productsRepository.deleteProductsById(id);
	
	}
	
	
}
