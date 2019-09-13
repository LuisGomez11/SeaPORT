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

import com.backend.seaport.deal.service.ServiceService;
import com.backend.seaport.deal.service.ServicesGeneratedService;
import com.backend.seaport.model.Services;
import com.backend.seaport.model.ServicesGenerated;
import com.backend.seaport.view.resource.vo.ServicesVo;

/**
 * @author christian
 *
 */

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api")

public class ServiceResources {
	
	private final ServiceService serviceService;
	private final ServicesGeneratedService servicesGeneratedservice;

	public ServiceResources(ServiceService servicesService, ServicesGeneratedService servicesGeneratedService) {
		this.serviceService = servicesService;
		this.servicesGeneratedservice = servicesGeneratedService;
	};
	
	@PostMapping("/services/create")
	public ResponseEntity<Services> POSTServices(@RequestBody ServicesVo servicesVo){
		Services services = new Services();
		
		services.setName(servicesVo.getName());
		
		//if (services.getName().isEmpty()) {
			//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		//} else {
			return new ResponseEntity<>(this.serviceService.createService(services), HttpStatus.CREATED);
	//	}
	};
	
	@PutMapping("/services/update/{id}")
	public ResponseEntity<Services> PUTService(@PathVariable("id") String id, ServicesVo servicesVo){
		
		Services services = this.serviceService.findByS(id);
		
		if(services == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			services.setName(servicesVo.getName());
		}
		return new ResponseEntity<>(this.serviceService.updateService(services), HttpStatus.OK);
	};
	
	@DeleteMapping("/services/delete/{id}")
	public void DELETEService(@PathVariable String id) {
		Services services = this.serviceService.findByS(id);
		ServicesGenerated servicesGenerated = this.servicesGeneratedservice.findByIS(id);

		if (services != null) {
			this.servicesGeneratedservice.elimanateServiceGenerated(servicesGenerated);
		}
	};
	
	@GetMapping("/services")
	public ResponseEntity<List<Services>> GETService(){
		return ResponseEntity.ok(this.serviceService.findAllServices());
	};
};
