/**
 * 
 */
package com.backend.seaport.view.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.seaport.deal.service.ServicesGeneratedService;
import com.backend.seaport.model.ServicesGenerated;
import com.backend.seaport.view.resource.vo.ServicesGeneratedVo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author christian
 *
 */

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/api")
public class ServicesGeneratedResources {

	private final ServicesGeneratedService servicesGeneratedService;

	public ServicesGeneratedResources(ServicesGeneratedService servicesGeneratedService) {
		this.servicesGeneratedService = servicesGeneratedService;
	}

	@PostMapping("/servicesGenerated/create")
	@ApiOperation(value = "Create service generated", notes = "Service to crate a new service generated")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "service generated create successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<ServicesGenerated> POSTServicesGenerated(
			@RequestBody ServicesGeneratedVo servicesGeneratedVo) {

		ServicesGenerated servicesGenerated = new ServicesGenerated();
		try {
			servicesGenerated.setIdEntityG(UUID.randomUUID().toString());
			servicesGenerated.setIdEntityM(servicesGenerated.getIdEntityG());
			servicesGenerated.setIdService(servicesGeneratedVo.getIdService());
			servicesGenerated.setReference(servicesGeneratedVo.getReference());
			servicesGenerated.setLloyd(servicesGeneratedVo.getLloyd());
			servicesGenerated.setUvi(servicesGeneratedVo.getUvi());
			servicesGenerated.setDock(servicesGeneratedVo.getDock());
			servicesGenerated.setDateAppointment(servicesGeneratedVo.getDateAppointment());
			servicesGenerated.setHourAppointment(servicesGeneratedVo.getHourAppointment());
			servicesGenerated.setHrsOp(servicesGeneratedVo.getHrsOp());
			servicesGenerated.setDateEnd(servicesGeneratedVo.getDateEnd());
			servicesGenerated.setHourEnd(servicesGeneratedVo.getHourEnd());
			servicesGenerated.setState(servicesGeneratedVo.getState());
			servicesGenerated.setTerminal(servicesGeneratedVo.getTerminal());

			return new ResponseEntity<>(this.servicesGeneratedService.createServiceGenerated(servicesGenerated),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@PutMapping("/servicesGenerated/update/{id}")
	@ApiOperation(value = "update service generated", notes = "Service to update a service generated")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "service generated updated successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<ServicesGenerated> PUTServicesGenerated(@PathVariable("id") String id,
			ServicesGeneratedVo servicesGeneratedVo) {

		try {
			ServicesGenerated servicesGenerated = this.servicesGeneratedService.findByIS(id);
			if (servicesGenerated == null) {
				return new ResponseEntity<ServicesGenerated>(HttpStatus.NOT_FOUND);
			} else {
				servicesGenerated.setIdService(servicesGeneratedVo.getIdService());
				servicesGenerated.setReference(servicesGeneratedVo.getReference());
				servicesGenerated.setLloyd(servicesGeneratedVo.getLloyd());
				servicesGenerated.setUvi(servicesGeneratedVo.getUvi());
				servicesGenerated.setDock(servicesGeneratedVo.getDock());
				servicesGenerated.setDateAppointment(servicesGeneratedVo.getDateAppointment());
				servicesGenerated.setHourAppointment(servicesGeneratedVo.getHourAppointment());
				servicesGenerated.setHrsOp(servicesGeneratedVo.getHrsOp());
				servicesGenerated.setDateEnd(servicesGeneratedVo.getDateEnd());
				servicesGenerated.setHourEnd(servicesGeneratedVo.getHourEnd());
				servicesGenerated.setState(servicesGeneratedVo.getState());
				servicesGenerated.setTerminal(servicesGeneratedVo.getTerminal());
			}
			;

			return new ResponseEntity<>(this.servicesGeneratedService.updateServiceGenerated(servicesGenerated),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@DeleteMapping("/servicesGenerated/delete/{id}")
	@ApiOperation(value = "delete service generated", notes = "Service to delete a service generated")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "service generated deleted successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public void DELETEServiceGenerated(@PathVariable("id") String id) {
		try {
			ServicesGenerated servicesGenerated = this.servicesGeneratedService.findByIS(id);
			if (servicesGenerated != null) {
				this.servicesGeneratedService.elimanateServiceGenerated(servicesGenerated);
			}
			;
		} catch (Exception e) {

		}
	};

	@GetMapping("/servicesGenerated")
	@ApiOperation(value = "to list services Generated", notes = "Service to list all services generated")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "services generated found"),
			@ApiResponse(code = 404, message = "services generated not found") })
	public ResponseEntity<List<ServicesGenerated>> GETallServicesGenerated() {
		try {
			return ResponseEntity.ok(this.servicesGeneratedService.findallServiceGenerated());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
	
	@GetMapping("/ServicesGenerated/{id}")
	@ApiOperation(value = "to find service generated by id", notes = "Service to find a service generated by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "services finded"),
			@ApiResponse(code = 404, message = "services generated not found") })
	public ResponseEntity<ServicesGenerated> GETIDservicesGeneratde(@PathVariable("id") String id){
		try {
			return ResponseEntity.ok(this.servicesGeneratedService.findByIS(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
