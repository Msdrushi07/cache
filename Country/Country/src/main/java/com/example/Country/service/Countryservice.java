package com.example.Country.service;


import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.Country.entity.Country;

import com.example.Country.repository.Countryrepo;





@Service

public class Countryservice {
	
	@Autowired
	private Countryrepo countryrepo;
	
	@Autowired
	private CacheManager cachemanager;
	
  public static final org.slf4j.Logger logger= LoggerFactory.getLogger(Countryservice.class);

	
	public Country savecountry(Country country) {

			
	Country country1=countryrepo.save(country);
	return country1;
	}
	
	
	public List<Country> getcountry(){
		logger.info("Fetching from DB");
		return countryrepo.findAll();

	}
	
	public Country getbyid(int id) {
		return countryrepo.findById(id).get();
	}
	
	@Scheduled(fixedDelayString= "PT30S")
	public void clearcache() {
		cachemanager.getCacheNames().stream().forEach(cachename -> cachemanager.getCache(cachename).clear());
	}
	
	
	

}
