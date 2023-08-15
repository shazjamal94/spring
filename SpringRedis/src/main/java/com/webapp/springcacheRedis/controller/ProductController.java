package com.webapp.springcacheRedis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.springcacheRedis.model.Product;

// MAKE METHOD STATIC IS NOT CACHED

@RestController
public class ProductController {

	@RequestMapping("/products")
	@Cacheable(value="Products")
	public List<Product> GetAllProduct(){
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1, "Dell"));
		list.add(new Product(2, "HP"));
		list.add(new Product(3, "lenovo"));
		System.out.println("IN CONSOLE");
		return list;
		
		
	}
@CacheEvict(value = "Products", allEntries=true)
@DeleteMapping("/deleteProducts")
public void deleteUserByID() {
		
	List<Product> list = GetAllProduct();
		
		list.removeAll(list);
		
	}
	

}
