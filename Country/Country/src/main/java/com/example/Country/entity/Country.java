package com.example.Country.entity;



import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity
@Table(name="Country")
public class Country {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy="country",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Region> regions=new ArrayList<>();	
	

	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

}
