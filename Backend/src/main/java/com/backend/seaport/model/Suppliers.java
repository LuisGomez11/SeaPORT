/**
 * 
 */
package com.backend.seaport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

/**
 * @author christian
 *
*/
@Data
@Entity
@Table(name = "proveedores")
@EntityScan("Suppliers")
@NamedQuery(name = "Suppliers.findByIdSuppliers", query = "Select c from Suppliers c where c.codSupplier = ?1")
public class Suppliers {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2") 
	@Column(name = "cod_proveedor")
	private String codSupplier;
	@Column(name = "nombre")
	private String name;
	@Column(name = "telefono")
	private String phone;
	@Column(name = "movil")
	private String cell;
	@Column(name = "correo")
	private String email;
	@Column(name = "nit")
	private String nit;
	@Column(name = "canTra")
	private int canTra;
}
 
