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

import com.backend.seaport.deal.service.PhysicalEntityService;
import com.backend.seaport.model.PhysicalEntity;
import com.backend.seaport.view.resource.vo.PhysicalEntityVo;

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
@Api(tags = "PhysicalEntity")
public class PhysicalEntityResources {

	private final PhysicalEntityService physicalEntityService;

	public PhysicalEntityResources(PhysicalEntityService physicalEntityService) {
		this.physicalEntityService = physicalEntityService;
	};

	@PostMapping("/physicalentity/create")
	@ApiOperation(value = "Create physical entity", notes = "Service to crate a new physical entity")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "physiscal entity create successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<PhysicalEntity> POSTphysicalEntity(@RequestBody PhysicalEntityVo physicalEntityVo) {
		try {
			if (physicalEntityVo == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			PhysicalEntity physicalEntity = new PhysicalEntity();

			physicalEntity.setName(physicalEntityVo.getName());
			physicalEntity.setType(physicalEntityVo.getType());

			return new ResponseEntity<>(this.physicalEntityService.createPhysicalEntity(physicalEntity),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@PutMapping("/physicalentity/update/{id}")
	@ApiOperation(value = "update physicalentity", notes = "assigned service to update a physicalentity")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "physicalentity updated successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<PhysicalEntity> PUTphysicalEntity(@PathVariable("id") String id,
			PhysicalEntityVo physicalEntityVo) {

		try {
			PhysicalEntity physicalEntity = this.physicalEntityService.findByCode(id);

			if (physicalEntityVo == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

			physicalEntity.setName(physicalEntityVo.getName());
			physicalEntity.setType(physicalEntityVo.getType());

			return new ResponseEntity<>(this.physicalEntityService.createPhysicalEntity(physicalEntity),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@DeleteMapping("/physicalentity/delete/{id}")
	@ApiOperation(value = "delete physical entity", notes = "Service to delete a physical entity")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "physical entity deleted successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public void DELETEphysicalEntity(@PathVariable("id") String id) {
		try {
			PhysicalEntity physicalEntity = this.physicalEntityService.findByCode(id);
			if (physicalEntity != null)
				this.physicalEntityService.deletePhysicalEntity(physicalEntity);
		} catch (Exception e) {
			// TODO: handle exception
		}
	};

	@GetMapping("/physicalentity")
	@ApiOperation(value = "to list physical entity", notes = "Service to list all physical entity")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "physical entity found"),
			@ApiResponse(code = 404, message = "physical entity not found") })
	public ResponseEntity<List<PhysicalEntity>> GETphysicalEntity() {
		try {
			return ResponseEntity.ok(this.physicalEntityService.findAllPhysicalEntity());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@GetMapping("/physicalentity/{id}")
	@ApiOperation(value = "to find physical entity by id", notes = "Service to find a physical entity by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "physical entity finded"),
			@ApiResponse(code = 404, message = "physical entity not found") })
	public ResponseEntity<PhysicalEntity> GETIDphysicalEntity(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(this.physicalEntityService.findByCode(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
}
