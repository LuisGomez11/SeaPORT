/**
 * 
 */
package com.backend.seaport.deal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.seaport.deal.repository.ServiceGeneratedRepository;
import com.backend.seaport.model.ServicesGenerated;

/**
 * @author christian clase para controlar las peticiones a la base de datos de
 *         servicios generados
 *
 */
@Service
@Transactional(readOnly = false)
public class ServicesGeneratedService {
	
	private final ServiceGeneratedRepository serviceGeneratedRepository;

	public ServicesGeneratedService(ServiceGeneratedRepository serviceGeneratedRepository) {
		this.serviceGeneratedRepository = serviceGeneratedRepository;
	}

	/*
	 * metodo para guardar un servicio generado
	 * 
	 */
	@Transactional
	public ServicesGenerated createServiceGenerated(ServicesGenerated servicesGenerated) {
		return this.serviceGeneratedRepository.save(servicesGenerated);
	}

	/*
	 * metodo para actualizar un servicio generado
	 * 
	 */
	@Transactional
	public ServicesGenerated updateServiceGenerated(ServicesGenerated servicesGenerated) {
		return this.serviceGeneratedRepository.save(servicesGenerated);
	}

	/*
	 * metodo para eliminar un servicio generado
	 * 
	 */
	@Transactional
	public void elimanateServiceGenerated(ServicesGenerated servicesGenerated) {
		this.serviceGeneratedRepository.delete(servicesGenerated);
	}

	/*
	 * metodo para listar un servicio generado
	 * 
	 */
	@Transactional
	public List<ServicesGenerated> findallServiceGenerated() {
		return this.serviceGeneratedRepository.findAll();
	}
	/*
	 * metodo para listar un servicio generado
	 * 
	 */
	@Transactional
	public ServicesGenerated findByIS(String idEntityG) {
		return this.serviceGeneratedRepository.findByIdServices(idEntityG);	
	}
	
}
