package com.example.Country.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.Country.entity.Country;

import com.example.Country.entity.Region;
import com.example.Country.repository.Countryrepo;
import com.example.Country.repository.Regionrepo;

@Service
public class Regionservice {

	@Autowired
	private Regionrepo regionrepo;
	
	
	
	@Autowired
	private Countryrepo countryrepo;
	
	public Region saveregion(int id,Region region) {
		Country country=countryrepo.findById(id).get();
		
		
	
		region.setCountry(country);
		
		Region region1=regionrepo.save(region);
		return region1;
	}
	
	public List<Region> getregion(){
		return regionrepo.findAll();
		
	}
}
