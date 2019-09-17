/**
 * 
 */
package com.backend.seaport.deal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.seaport.model.PhysicalEntity;

/**
 * @author christian
 *
 */
public interface PhysicalEntityRepository extends JpaRepository <PhysicalEntity, String> {
	
	public PhysicalEntity findByIdEntity(String idEntity);
}
