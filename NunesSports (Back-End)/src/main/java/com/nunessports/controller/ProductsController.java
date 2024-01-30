package com.nunessports.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nunessports.model.Products;
import com.nunessports.service.ProductsService;

@RestController
@RequestMapping("/Products/v1")
public class ProductsController {
	private final ProductsService productsService;
	
	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> getAllProducts(
			@RequestParam(defaultValue = "0", name = "page")int page,
	        @RequestParam(defaultValue = "5", name = "size")int size){
		Pageable paging = PageRequest.of(page, size);
		Page<Products> products = productsService.findAllProducts(paging);
		
		Map<String, Object> response = new HashMap<>();
	      response.put("content", products.getContent());
	      response.put("currentPage", products.getNumber());
	      response.put("totalItems", products.getTotalElements());
	      response.put("totalPages", products.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Products> getIdProducts(
			@PathVariable("id")Long id){
		Products products = productsService.findProductsById(id);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<Page<Products>> getNameProducts(
			@RequestParam(name = "name", required = false)String name,
			@RequestParam(name = "lowestPrice", defaultValue = "0")BigDecimal lowest, 
			@RequestParam(name = "highestPrice", defaultValue = "31500")BigDecimal highest,
			@RequestParam(defaultValue = "0", name = "page")int page,
	        @RequestParam(defaultValue = "5", name = "size")int size){
		Page<Products> products;
		Pageable paging = PageRequest.of(page, size);
		
		if(name != null) {
		products = productsService
				.findProductsByFilter(name, lowest, highest, paging);
		}
		else {
			products = productsService
					.findProductsByPrice(lowest, highest, paging);
		}
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Products> addProducts(@RequestBody Products products){
		Products newProducts = productsService.addProducts(products);
		return new ResponseEntity<>(newProducts, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Products> updateProducts(@PathVariable("id")Long id, @RequestBody Products products){
		Products updateProducts = productsService.updateProducts(id, products);
		return new ResponseEntity<>(updateProducts, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducts(@PathVariable("id")Long id){
		productsService.deleteProducts(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
