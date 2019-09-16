/**
 * 
 */
package com.backend.seaport.view.resource.vo;

import lombok.Data;

/**
 * @author christian
 *
 */
@Data
public class AssignedServicesVo {

	private String reference;
	private String codeSupplier;
	private int quantity;
	private String observations;
	private String totalHours;
	private String state;
}
