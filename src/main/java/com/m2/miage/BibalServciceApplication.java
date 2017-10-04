package com.m2.miage;

import com.m2.miage.searchservice.boundary.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@EnableAutoConfiguration
@SpringBootApplication
public class BibalServciceApplication {

	@Autowired
	private EntityManager em;

	@Bean
	SearchService searchService() {
		SearchService searchService = new SearchService(em);
		searchService.initializeSearch();
		return searchService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BibalServciceApplication.class, args);
	}
}
