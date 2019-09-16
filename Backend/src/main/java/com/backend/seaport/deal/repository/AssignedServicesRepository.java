package com.backend.seaport.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.seaport.model.AssignedServices;

public interface AssignedServicesRepository extends JpaRepository<AssignedServices, String> {

	public AssignedServices findByAssigned(String idService);
}
