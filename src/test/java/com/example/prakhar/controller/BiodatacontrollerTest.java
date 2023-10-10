package com.example.prakhar.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.prakhar.DTO.BioDataDTO;
import com.example.prakhar.service.BiodataService;

class BiodatacontrollerTest {

	@InjectMocks
	Biodatacontroller biodatacontroller;
	
	@Mock
	BiodataService biodataService;
	
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); //in order for Mock and InjectMocks annotations to take effect, you need to call MockitoAnnotations.openMocks(this);
    }
	
	@Test
    public void testGetAll(){
	
		List<BioDataDTO> mockbiodata = Arrays.asList(
				new BioDataDTO(1, "Prakhar", "abc@gmail.com", 213213, 999000, "Manager"),
				new BioDataDTO(1, "Ajay", "abc1@gmail.com", 2133, 99000, "Lead")
				);
	
		when(biodataService.getAll()).thenReturn(mockbiodata);
		
		// Call the controller method
		
		ResponseEntity<List<BioDataDTO>> response = biodatacontroller.getAll();
		
		//verify
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockbiodata, response.getBody());
		
		verify(biodataService, times(1)).getAll();
		
	
	}

	
	
	@Test
    public void testGetUserById(){
	Integer mock =1;
		
		BioDataDTO mockbiodata = 
				new BioDataDTO(1, "Prakhar", "abc@gmail.com", 213213, 999000, "Manager");
	
		when(biodataService.getUserById(mock)).thenReturn(mockbiodata);
		
		// Call the controller method
		
		ResponseEntity<BioDataDTO>response = biodatacontroller.getUserById(mock);
		
		//verify
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(mockbiodata, response.getBody());
		
		verify(biodataService, times(1)).getUserById(mock);
		
	
	}

	
	
	@Test
    public void testCreate(){
	
		
		BioDataDTO mockbiodata = 
				new BioDataDTO(1, "Prakhar", "abc@gmail.com", 213213, 999000, "Manager");
	
		when(biodataService.create(mockbiodata)).thenReturn(mockbiodata);
		
		// Call the controller method
		
		ResponseEntity<BioDataDTO>response = biodatacontroller.create(mockbiodata);
		
		//verify
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(mockbiodata, response.getBody());
		
		verify(biodataService, times(1)).create(mockbiodata);
		
	
	}

	
	
	
	
}