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
@Table(name = "servicio")
@EntityScan("Service")
@NamedQuery(name = "Services.findByIdServices", query = "Select c from Services c where c.idServices = ?1")
public class Services {
	@Id
	@Column(name = "id_servicio")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")  
	private String idServices;
	@Column(name = "nombre")
	private String name;

	public Services() {

	};
};
