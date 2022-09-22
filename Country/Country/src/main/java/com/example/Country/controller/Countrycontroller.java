package com.example.Country.controller;

import java.lang.System.Logger;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Country.entity.Country;
import com.example.Country.service.Countryservice;


@RestController
@RequestMapping("/country")
public class Countrycontroller {

	@Autowired
	private Countryservice countryservice;
	
	
	@PostMapping("/save")
	public ResponseEntity<Country> savecountry(@RequestBody Country country){	
		Country countrydto1=countryservice.savecountry(country);
		return new ResponseEntity<>(countrydto1,HttpStatus.CREATED);
	}
	
	@Cacheable(value="country")
	@GetMapping("/get")
	public List<Country> getcountry(){
		return countryservice.getcountry();
	}
	
	@GetMapping("/get/{id}")
	public Country getbyid(@PathVariable int id) {
		return countryservice.getbyid(id);
	}
}
