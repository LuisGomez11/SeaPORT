package com.backend.seaport.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.seaport.model.Services;

public interface ServiceRepository extends JpaRepository<Services, String>{
	
	public Services findByIdServices(String idServices);
}
