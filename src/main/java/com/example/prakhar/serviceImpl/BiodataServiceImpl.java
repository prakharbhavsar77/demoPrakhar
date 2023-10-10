package com.example.prakhar.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prakhar.DTO.BioDataDTO;
import com.example.prakhar.entity.BioData;
import com.example.prakhar.exception.ResouceNotFoundException;
import com.example.prakhar.repo.biodatarepo;
import com.example.prakhar.service.BiodataService;

@Service
public class BiodataServiceImpl implements BiodataService {

	
	@Autowired
	private biodatarepo biodatarepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public BioDataDTO create(BioDataDTO bioDataDTO) {
		
		BioData bioData = this.dtoToBioData(bioDataDTO);
		
		BioData saved = this.biodatarepo.save(bioData);
		
		 return this.bioDataToDTO(saved);
	}

	@Override
	public BioDataDTO update(BioDataDTO bioDataDTO, Integer id) {
		
		BioData bioData = this.biodatarepo.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Biodata ", "Biodata Id",id));
		
		
		bioData.setName(bioDataDTO.getName());
		bioData.setEmailId(bioDataDTO.getEmailId());
		bioData.setPhoneno(bioData.getPhoneno());
		bioData.setDesignation(bioDataDTO.getDesignation());
		bioData.setSalary(bioDataDTO.getSalary());
		
		BioData updated = this.biodatarepo.save(bioData);
		
		return this.modelMapper.map(updated,BioDataDTO.class);
	}

	@Override
	public BioDataDTO getUserById(Integer id) {
		
		BioData bioData = this.biodatarepo.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Biodata ", "Biodata Id",id));
		
		return this.modelMapper.map(bioData, BioDataDTO.class);
		
	}

	@Override
	public void delete(Integer id) {
		BioData bioData = this.biodatarepo.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Biodata ", "Biodata Id",id));
		
		this.biodatarepo.delete(bioData);
		
	}

	

	@Override
	public BioDataDTO inhandSalary(Integer id) {
		BioData bioData = this.biodatarepo.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Biodata ", "Biodata Id",id));
		
		bioData.setSalary(bioData.getSalary() - 500);
		biodatarepo.save(bioData);
		return this.modelMapper.map(bioData, BioDataDTO.class);
		
	}

	@Override
	public List<BioDataDTO> getAll() {
		
		List<BioData> bioDatas = this.biodatarepo.findAll();
		
		List<BioDataDTO> bioDataDtos = bioDatas.stream().map((cat) -> this.modelMapper.map(cat, BioDataDTO.class))
				.collect(Collectors.toList());

		return bioDataDtos;
	}
		
	
	
	private BioData dtoToBioData(BioDataDTO bioDataDTO)
	{
		BioData bioData =  this.modelMapper.map(bioDataDTO, BioData.class);
		
		
		 return bioData;
	}
	
	
	
	private BioDataDTO bioDataToDTO(BioData bioData)
	{
		BioDataDTO bioDataDTO = this.modelMapper.map(bioData, BioDataDTO.class);
	
		 return bioDataDTO;
	}
	}

	

	
	

