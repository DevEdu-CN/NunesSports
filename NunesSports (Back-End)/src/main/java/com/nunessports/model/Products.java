package com.nunessports.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@Column(nullable = false)
	private String name;
	private String description;
	
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	
	public Products() {
		
	};
	
	public Products(String name, 
			String description, BigDecimal price) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}
	
	public long getId() {
		return id;
	}
	
	public long setId(long id) {
		return this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public String setName(String name) {
		return this.name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String setDescription(String description) {
		return this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public BigDecimal setPrice(BigDecimal price) {
		return this.price = price;
	}
	
	public String toString() {
		return "Product{" + 
				"id=" + id + '\'' + 
				"name=" + name + '\'' + 
				"description=" + description + '\'' + 
				"price=" + price + '\'' +  
				'}';
		
	}
	
}