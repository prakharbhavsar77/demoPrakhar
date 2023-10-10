package com.example.prakhar.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResouceNotFoundException extends RuntimeException{
	
	
	String resouceName;
	String filedName;
	long fieldValue;
	
	
	public ResouceNotFoundException(String resouceName, String filedName, long fieldValue) {
		super(String.format("%s not found with %s : %s", resouceName, filedName,fieldValue ));
		this.resouceName = resouceName;
		this.filedName = filedName;
		this.fieldValue = fieldValue;
	}
	

}
