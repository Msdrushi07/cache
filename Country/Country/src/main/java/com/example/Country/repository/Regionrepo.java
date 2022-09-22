package com.example.Country.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Country.entity.Region;

public interface Regionrepo extends JpaRepository<Region,Integer>{

}
