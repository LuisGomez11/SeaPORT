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
@Table(name = "entidad_fisica")
@EntityScan("PhysicalEntity")
@NamedQuery(name = "PhysicalEntity.findByIdEntity", query = "Select c from PhysicalEntity c where c.idEntity = ?1")
public class PhysicalEntity {
	
	@Id
	@Column(name = "id_entidad")
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")  
	private String idEntity;
	@Column(name="name")
	private String name;
	@Column(name="tipo")
	private String type;
	
	public PhysicalEntity() {
		
	};
}
