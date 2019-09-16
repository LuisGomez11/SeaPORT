package com.backend.seaport.deal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.seaport.deal.repository.SuppliersRepository;
import com.backend.seaport.model.Suppliers;

/*
 * @author christian
 * */
@Service
@Transactional(readOnly = false)
public class SuppliersService {
	
	private final SuppliersRepository suppliersRepository;
	
	public SuppliersService(SuppliersRepository suppliersRepository) {
		
		this.suppliersRepository = suppliersRepository;
	};
	
	/*
	 * metodo para guardar un proveedor
	 * 
	 */
	@Transactional
	public Suppliers createSupplier(Suppliers suppliers) {
		return this.suppliersRepository.save(suppliers);
	};
	
	/*
	 * metodo para actualizar un proveedor
	 * 
	 */
	@Transactional
	public Suppliers updateSupplier(Suppliers suppliers) {
		return this.suppliersRepository.save(suppliers);
	};
	
	/*
	 * metodo para eliminar un proveedor
	 * 
	 */
	@Transactional
	public void  deleteSuppiers(Suppliers suppliers) {
		this.suppliersRepository.delete(suppliers);
	};
	
	/*
	 * metodo para traer una lista de proveedores
	 * 
	 */
	@Transactional
	public List<Suppliers> findAllSuppliers(){
		return this.suppliersRepository.findAll();
	};
	
	/*
	 * metodo para buscar un proveedor por el id
	 * 
	*/
	@Transactional
	public Suppliers findByCo(String codSupplier) {
		return this.suppliersRepository.findByIdSuppliers(codSupplier);
	};
	
};
