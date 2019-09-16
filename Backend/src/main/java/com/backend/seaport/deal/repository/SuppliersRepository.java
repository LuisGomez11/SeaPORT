/**
 * 
 */
package com.backend.seaport.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.seaport.model.Suppliers;

/**
 * @author christian
 *
 */
public interface SuppliersRepository extends JpaRepository<Suppliers, String>{
	
	public Suppliers findByIdSuppliers(String codSupllier);
}
