package com.webapp.springcacheRedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCacheWithRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCacheWithRedisApplication.class, args);
	}

}
