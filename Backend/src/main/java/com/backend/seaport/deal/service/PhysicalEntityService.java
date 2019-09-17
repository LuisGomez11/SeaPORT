/**
 * 
 */
package com.backend.seaport.deal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.seaport.deal.repository.PhysicalEntityRepository;
import com.backend.seaport.model.PhysicalEntity;



/**
 * @author christian
 *
 */
@Service
@Transactional(readOnly = false)
public class PhysicalEntityService {
	
	private final PhysicalEntityRepository physicalEntityRepository;
	
	public PhysicalEntityService(PhysicalEntityRepository physicalEntityRepository) {

		this.physicalEntityRepository = physicalEntityRepository;
	};
	
	/*
	 * metodo para crear una entidad fisica
	 * 
	 */
	
	public PhysicalEntity createPhysicalEntity(PhysicalEntity physicalEntity) {
		return this.physicalEntityRepository.save(physicalEntity);
	};
	
	/*
	 * metodo para actualizar una entidad fisica
	 * 
	 */
	
	public PhysicalEntity updatePhysicalEntity(PhysicalEntity physicalEntity) {
		return this.physicalEntityRepository.save(physicalEntity);
	};
	
	/*
	 * metodo para eliminar una entidad fisica
	 * 
	 */
	
	public void deletePhysicalEntity(PhysicalEntity physicalEntity) {
		this.physicalEntityRepository.delete(physicalEntity);
	};
	
	/*
	 * metodo para listar las entidades fisicas
	 * 
	 */
	
	public List<PhysicalEntity> findAllPhysicalEntity(){
		return this.physicalEntityRepository.findAll();
	};
	
	/*
	 * metodo para buscar una entidad fisica
	 * 
	 */
	
	public PhysicalEntity findByCode(String code) {
		return this.physicalEntityRepository.findByIdEntity(code);
	};
};
