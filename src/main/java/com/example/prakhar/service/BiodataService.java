package com.example.prakhar.service;

import java.util.List;

import com.example.prakhar.DTO.BioDataDTO;
import com.example.prakhar.entity.BioData;

public interface BiodataService {


	BioDataDTO create(BioDataDTO bioDataDTO);
	
	BioDataDTO update(BioDataDTO bioDataDTO, Integer id);
	
	BioDataDTO getUserById(Integer id);

	void delete(Integer id);
	
	BioDataDTO inhandSalary(Integer id);

	List<BioDataDTO> getAll();
	

	
}
