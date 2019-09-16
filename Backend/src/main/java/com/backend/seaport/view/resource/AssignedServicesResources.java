/**
 * 
 */
package com.backend.seaport.view.resource;

import java.util.List;

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

import com.backend.seaport.deal.service.AssignedServicesServices;
import com.backend.seaport.model.AssignedServices;
import com.backend.seaport.view.resource.vo.AssignedServicesVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author christian
 *
 */
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/v1/api")
@Api(tags = "AssignedServices")
public class AssignedServicesResources {
	
	private final AssignedServicesServices assignedServicesServices;
	
	public AssignedServicesResources(AssignedServicesServices assignedServicesServices) {
		this.assignedServicesServices = assignedServicesServices;
	};
	
	@PostMapping("/assignedservices/create")
	@ApiOperation(value = "Create assigned service", notes = "Service to crate a new assigned service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "assigned service create successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<AssignedServices> POSTassignedServices(@RequestBody AssignedServicesVo assignedServicesVo){
		AssignedServices assignedServices = new AssignedServices();
		try {
			assignedServices.setReference(assignedServicesVo.getReference());
			assignedServices.setCodeSupplier(assignedServicesVo.getCodeSupplier());
			assignedServices.setQuantity(assignedServicesVo.getQuantity());
			assignedServices.setObservations(assignedServicesVo.getObservations());
			assignedServices.setTotalHours(assignedServicesVo.getTotalHours());
			assignedServices.setState(assignedServicesVo.getState());
			
			return new ResponseEntity<>(this.assignedServicesServices.createAssignedService(assignedServices), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
	
	@PutMapping("/assignedservices/update/{id}")
	@ApiOperation(value = "update assigned services", notes = "assigned service to update a supplier")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "assigned services updated successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<AssignedServices> PUTassignedServices(@PathVariable("id") String id, AssignedServicesVo assignedServicesVo){
		try {
			if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			AssignedServices assignedServices = this.assignedServicesServices.findByCode(id);
			
			assignedServices.setReference(assignedServicesVo.getReference());
			assignedServices.setCodeSupplier(assignedServicesVo.getCodeSupplier());
			assignedServices.setQuantity(assignedServicesVo.getQuantity());
			assignedServices.setObservations(assignedServicesVo.getObservations());
			assignedServices.setTotalHours(assignedServicesVo.getTotalHours());
			assignedServices.setState(assignedServicesVo.getState());
			
			return new ResponseEntity<>(this.assignedServicesServices.updateAssignedService(assignedServices), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
	
	@DeleteMapping("/AssignedService/delete/{id}")
	@ApiOperation(value = "delete assigned Service", notes = "Service to delete a assigned service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Assigned service deleted successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public void DELETEassignedService(@PathVariable("id") String id) {
		try {
			AssignedServices assignedServices = this.assignedServicesServices.findByCode(id);
			if (assignedServices != null)
				this.assignedServicesServices.deleteAssignedService(assignedServices);;
		} catch (Exception e) {
			// TODO: handle exception
		}
	};
	
	@GetMapping("/assignedservice")
	@ApiOperation(value = "to list assigned Service", notes = "Service to list all assigned Service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "suppliers found"),
			@ApiResponse(code = 404, message = "assigned Service found") })
	public ResponseEntity<List<AssignedServices>> GETassignedservice() {
		try {
			return ResponseEntity.ok(this.assignedServicesServices.findAllAssignedServices());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
	
	@GetMapping("/assignedservice/{id}")
	@ApiOperation(value = "to find assiged service by id", notes = "Service to find a assigned service by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "supplier finded"),
			@ApiResponse(code = 404, message = "assigned service not found") })
	public ResponseEntity<AssignedServices> GETIDsupplier(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(this.assignedServicesServices.findByCode(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
}
