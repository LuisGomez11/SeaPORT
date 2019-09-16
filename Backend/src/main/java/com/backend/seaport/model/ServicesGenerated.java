/**
 * 
 */
package com.backend.seaport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

/**
 * @author christian modelo de la tabla servicios generados
 *
 */
@Data
@Entity
@Table(name = "servicios_generados")
@EntityScan("ServicesGenerated")
@NamedQuery(name = "ServicesGenerated.findByIdServices", query = "Select c from ServicesGenerated c where c.idService = ?1")
public class ServicesGenerated {

	@Column(name = "id_entidadG")
	private String idEntityG;
	@Column(name = "id_entidadM")
	private String idEntityM;
	@Id
	@Column(name = "id_servicio")
	private String idService;
	@Column(name = "referencia")
	private String reference;
	@Column(name = "lloyd")
	private String lloyd;
	@Column(name = "uvi")
	private String uvi;
	@Column(name = "dock")
	private String dock;
	@Column(name = "date_appointment")
	private String dateAppointment;
	@Column(name = "hour_Appointment")
	private String hourAppointment;
	@Column(name = "hrs_Op")
	private String hrsOp;
	@Column(name = "date_end")
	private String dateEnd;
	@Column(name = "hour_end")
	private String hourEnd;
	@Column(name = "state")
	private String state;
	@Column(name = "terminal")
	private String terminal;

	public ServicesGenerated() {

	}

}
