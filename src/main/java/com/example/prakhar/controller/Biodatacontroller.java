package com.example.prakhar.controller;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prakhar.DTO.BioDataDTO;
import com.example.prakhar.service.BiodataService;

@RestController
@RequestMapping("/api")
public class Biodatacontroller {

	@Autowired
	private BiodataService biodataService;
	
	@PostMapping("/create")
	public ResponseEntity<BioDataDTO> create(@RequestBody BioDataDTO bioDataDTO)
	{
		BioDataDTO created = biodataService.create(bioDataDTO);
		
		return new ResponseEntity<>(bioDataDTO,HttpStatus.CREATED);
	}
	  
	@GetMapping("/get/{id}")
	public ResponseEntity<BioDataDTO> getUserById(@PathVariable Integer id)
	{
		
		return ResponseEntity.ok(this.biodataService.getUserById(id));
	}
	
	
	@DeleteMapping("/delete/{id}")
	public com.example.prakhar.DTO.ApiResponse delete(@PathVariable Integer id)
	{
		this.biodataService.delete(id);
		return new com.example.prakhar.DTO.ApiResponse("Biodata is successfully deleted !!", true);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<BioDataDTO> update(@RequestBody BioDataDTO bioDataDTO, @PathVariable Integer id)
	{
		BioDataDTO updated = this.biodataService.update(bioDataDTO, id);
		
		return new ResponseEntity<BioDataDTO>(updated,HttpStatus.OK);
	}
	
	@GetMapping("/ctc/{id}")
	public ResponseEntity<BioDataDTO> inhandSalary(@PathVariable Integer id)
	{
		BioDataDTO response = this.biodataService.inhandSalary(id);
		return new ResponseEntity<BioDataDTO>(response,HttpStatus.OK);
	}
	
	// get all
		@GetMapping("/")
		public ResponseEntity<List<BioDataDTO>> getAll() {
			List<BioDataDTO> all = this.biodataService.getAll();
			return ResponseEntity.ok(all);
		}
	
}
