package com.bootcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.bootcrud")
public class GlobalExceptionHandling {

	@ExceptionHandler(value = {EmployeeNotFound.class})
	public ResponseEntity<Object> employeeNotFound(EmployeeNotFound ex){
		
		EmployeeException emp = new EmployeeException();
		emp.setMessage(ex.getMessage());
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
