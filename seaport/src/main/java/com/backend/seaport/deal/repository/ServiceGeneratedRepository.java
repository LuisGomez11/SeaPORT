/**
 * 
 */
package com.backend.seaport.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.seaport.model.ServicesGenerated;

/**
 * @author christian
 *
 */
public interface ServiceGeneratedRepository extends JpaRepository<ServicesGenerated, String> {

	public ServicesGenerated findByIdServices(String idService);

}
