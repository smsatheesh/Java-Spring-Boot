package net.javaguides.springboot.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class ResourceNotFoundException extends RuntimeException {

	/*
	 * 
	 */

	public static final long serialVersionID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super( String.format( "%s not found with %s : '%s'", resourceName, fieldName, fieldValue ));
		System.out.printf( "%s not found with %s : '%s'", resourceName, fieldName, fieldValue );
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() { 
		return this.resourceName;
	}
	
	public String getFeildName() {
		return this.fieldName;
	}
	
	public Object getFeildValue() {
		return this.fieldValue;
	}
}
