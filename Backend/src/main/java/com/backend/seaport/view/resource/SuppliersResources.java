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

import com.backend.seaport.deal.service.SuppliersService;
import com.backend.seaport.model.Suppliers;
import com.backend.seaport.view.resource.vo.SuppliersVo;

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
@Api(tags = "Suppliers")
public class SuppliersResources {

	private final SuppliersService suppliersService;

	public SuppliersResources(SuppliersService suppliersService) {
		this.suppliersService = suppliersService;
	};

	@PostMapping("/suppliers/create")
	@ApiOperation(value = "Create service", notes = "Service to crate a new service")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "service create successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Suppliers> POStSuppliers(@RequestBody SuppliersVo suppliersVo) {
		Suppliers suppliers = new Suppliers();

		try {
			suppliers.setName(suppliersVo.getName());
			suppliers.setPhone(suppliersVo.getPhone());
			suppliers.setCell(suppliersVo.getCell());
			suppliers.setEmail(suppliersVo.getEmail());
			suppliers.setNit(suppliersVo.getNit());
			suppliers.setCanTra(suppliersVo.getCanTra());

			return new ResponseEntity<>(this.suppliersService.createSupplier(suppliers), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@PutMapping("/suppliers/update/{id}")
	@ApiOperation(value = "update supplier", notes = "Service to update a supplier")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "supplier updated successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public ResponseEntity<Suppliers> PUTsupplier(@PathVariable("id") String id, SuppliersVo suppliersVo) {
		try {
			Suppliers suppliers = this.suppliersService.findByCo(id);
			if (suppliers == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

			suppliers.setName(suppliersVo.getName());
			suppliers.setPhone(suppliersVo.getPhone());
			suppliers.setCell(suppliersVo.getCell());
			suppliers.setEmail(suppliersVo.getEmail());
			suppliers.setNit(suppliersVo.getNit());
			suppliers.setCanTra(suppliersVo.getCanTra());

			return new ResponseEntity<>(this.suppliersService.updateSupplier(suppliers), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@DeleteMapping("/suppliers/delete/{id}")
	@ApiOperation(value = "delete suppliers", notes = "Service to delete a supplier")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "supplier deleted successfully"),
			@ApiResponse(code = 400, message = "Invalid request") })
	public void DELETEsupplier(@PathVariable("id") String id) {
		try {
			Suppliers suppliers = this.suppliersService.findByCo(id);
			if (suppliers != null)
				this.suppliersService.deleteSuppiers(suppliers);
		} catch (Exception e) {
			// TODO: handle exception
		}
	};

	@GetMapping("/suppliers")
	@ApiOperation(value = "to list suppliers", notes = "Service to list all suppliers")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "suppliers found"),
			@ApiResponse(code = 404, message = "suppliers not found") })
	public ResponseEntity<List<Suppliers>> GETsuppliers() {
		try {
			return ResponseEntity.ok(this.suppliersService.findAllSuppliers());
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};

	@GetMapping("/suppliers/{id}")
	@ApiOperation(value = "to find supplier by id", notes = "Service to find a supplier by id")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "supplier finded"),
			@ApiResponse(code = 404, message = "supplier not found") })
	public ResponseEntity<Suppliers> GETIDsupplier(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(this.suppliersService.findByCo(id));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	};
};
