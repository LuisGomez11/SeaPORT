/**
 * 
 */
package com.backend.seaport.deal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.seaport.deal.repository.AssignedServicesRepository;
import com.backend.seaport.model.AssignedServices;

/**
 * @author christian
 *
 */
@Service
@Transactional(readOnly = false)
public class AssignedServicesServices {
	private final AssignedServicesRepository assignedServicesRepository;

	public AssignedServicesServices(AssignedServicesRepository assignedServicesRepository) {
		this.assignedServicesRepository = assignedServicesRepository;
	};

	/*
	 * metodo para guardar un servicio asignado
	 * 
	 */

	@Transactional
	public AssignedServices createAssignedService(AssignedServices assignedServices) {
		return this.assignedServicesRepository.save(assignedServices);
	};

	/*
	 * metodo para actualizar un servicio asignado
	 * 
	 */

	public AssignedServices updateAssignedService(AssignedServices assignedServices) {
		return this.assignedServicesRepository.save(assignedServices);
	};

	/*
	 * metodo para eliminar un servicio asignado
	 * 
	 */

	public void deleteAssignedService(AssignedServices assignedServices) {
		this.assignedServicesRepository.delete(assignedServices);
	};

	/*
	 * metodo para listar los servicio asignados
	 * 
	 */

	public List<AssignedServices> findAllAssignedServices() {
		return this.assignedServicesRepository.findAll();
	};

	/*
	 * metodo para buscar por codigo un servicio asignado
	 * 
	 */

	public AssignedServices findByCode(String code) {
		return this.assignedServicesRepository.findByAssigned(code);
	};

}
