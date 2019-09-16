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
@Table(name = "servicios_asignados")
@EntityScan("assignedServices")
@NamedQuery(name = "AssignedServices.findByAssigned", query = "Select c from AssignedServices c where c.code = ?1")
public class AssignedServices {
	@Id
	@Column(name = "codigo")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String code;
	@Column(name = "referencia")
	private String reference;
	@Column(name = "cod_proveedor")
	private String codeSupplier;
	@Column(name = "cantidad")
	private int quantity;
	@Column(name = "observaciones")
	private String observations;
	@Column(name = "hrs_Totales")
	private String totalHours;
	@Column(name = "estado")
	private String state;

	public AssignedServices() {

	};
};
