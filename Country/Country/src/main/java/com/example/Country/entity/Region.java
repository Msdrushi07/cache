package com.example.Country.entity;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Region")
public class Region {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int regionid;
	String region1;
	String region2;
	String region3;
	public int getRegionid() {
		return regionid;
	}
	public void setRegionid(int regionid) {
		this.regionid = regionid;
	}
	public String getRegion1() {
		return region1;
	}
	public void setRegion1(String region1) {
		this.region1 = region1;
	}
	public String getRegion2() {
		return region2;
	}
	public void setRegion2(String region2) {
		this.region2 = region2;
	}
	public String getRegion3() {
		return region3;
	}
	public void setRegion3(String region3) {
		this.region3 = region3;
	}

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne
	@JoinColumn
	@JsonBackReference
	private Country country;
		

	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	

}
