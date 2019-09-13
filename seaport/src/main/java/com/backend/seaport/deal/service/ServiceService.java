package com.backend.seaport.deal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.seaport.deal.repository.ServiceRepository;
import com.backend.seaport.model.Services;

@Service
@Transactional(readOnly = false)
public class ServiceService {

	private final ServiceRepository serviceRepository;

	public ServiceService(ServiceRepository serviceRepository) {

		this.serviceRepository = serviceRepository;
	};
	
	/*
	 * metodo para guardar un servicio
	 * 
	 */
	@Transactional
	public Services createService(Services services) {
		return this.serviceRepository.save(services);
	};
	
	/*
	 * metodo para actualizar un servicio
	 *   
	 */
	@Transactional
	public Services updateService(Services services) {
		return this.serviceRepository.save(services);
	};
	
	/*
	 * metodo para eliminar un servicio
	 * 
	 */
	@Transactional
	public void deleteService(Services services) {
		this.serviceRepository.delete(services);
	};
	
	/*
	 * metodo para listar los servicios
	 * 
	 */
	@Transactional
	public List<Services> findAllServices(){
		return this.serviceRepository.findAll();
	};
	
	/*
	 * metodo para buscar un servicio por el id 
	 * 
	 */
	@Transactional
	public Services findByS(String idServices) {
		return this.serviceRepository.findByIdServices(idServices);
	};
};
