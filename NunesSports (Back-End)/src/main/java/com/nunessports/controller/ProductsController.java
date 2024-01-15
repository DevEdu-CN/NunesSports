package com.nunessports.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nunessports.exception.userNotFoundException;
import com.nunessports.model.Products;
import com.nunessports.service.ProductsService;

@RestController
@RequestMapping("/Products")
public class ProductsController {
	private final ProductsService productsService;
	
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Products>> getAllProducts(){
		List<Products> products = productsService.findAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Products> getIdProducts(@PathVariable("id")Long id){
		Optional<Products> products = productsService.findProductsById(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
		
	}
	
	
}