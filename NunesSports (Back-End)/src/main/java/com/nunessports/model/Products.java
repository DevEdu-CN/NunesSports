package com.nunessports.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private long id;
	private String name;
	private String description;
	
	@Column(precision = 10, scale = 2)
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
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
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
