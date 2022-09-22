package com.example.Country.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Country.entity.Region;
import com.example.Country.service.Regionservice;

@RestController
@RequestMapping("/region")
public class Regioncontroller {
	
	@Autowired
	private Regionservice regionservice;
	
	@PostMapping("/save/{id}")
	public Region savergion(@PathVariable int id,@RequestBody Region regiondto) {
		return regionservice.saveregion(id, regiondto);
	}
	
	@GetMapping("/get")
	public List<Region> getregions(){
		return regionservice.getregion();
	}

}
