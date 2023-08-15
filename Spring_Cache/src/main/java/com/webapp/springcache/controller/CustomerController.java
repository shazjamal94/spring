package com.webapp.springcache.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.springcache.model.Customer;

@RestController
public class CustomerController {
	
	@RequestMapping("/customerinfo")  
	//defines a cache for method's return value  
	@Cacheable(value="customerInfo")  
	public List<Customer> customerInformation()  
	{  
	System.out.println("THIS PRINT ONLY ONCE - > customer information from cache");  
	//adding customer detail in the List  
	    List<Customer> detail=Arrays.asList(new Customer(1,"shaz","Current A/c", 250000.00));
	    
	                             
	return detail;  
	}  
	// how to clear cache
	@Autowired
	CacheManager cacheManager;
    
	
	 
	public void evictSingleCacheValue(String cacheName, String cacheKey) {
	    cacheManager.getCache(cacheName).evict(cacheKey);
	}
    
	@RequestMapping("/clearcache/{cacheName}") 
	public String evictAllCacheValues(@PathVariable String cacheName) {
	    cacheManager.getCache(cacheName).clear();
		return "cache clear";
	    
	}

}
