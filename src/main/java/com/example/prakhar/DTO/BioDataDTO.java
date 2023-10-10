package com.example.prakhar.DTO;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class BioDataDTO {

	private int id;
	private String name;
	private String emailId;
	private int phoneno;
	private int salary;
	private String designation;
}
