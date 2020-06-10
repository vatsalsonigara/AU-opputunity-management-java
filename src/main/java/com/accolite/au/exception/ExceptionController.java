package com.accolite.au.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.LogFactory;
import org.springframework.hateoas.mediatype.hal.forms.Jackson2HalFormsModule.HalFormsHandlerInstantiator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	//private Log logger=LogFactory.getLog(ExceptionController.class);
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception e) throws Exception{
		ExceptionResponse eResponse=new ExceptionResponse();
		eResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		eResponse.setDescription(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(eResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException e) throws Exception{
		ExceptionResponse eResponse=new ExceptionResponse();
		eResponse.setCode(HttpStatus.NOT_FOUND.value());
		eResponse.setDescription(e.getMessage());
		System.out.println(e);
		return new ResponseEntity<ExceptionResponse>(eResponse,HttpStatus.NOT_FOUND);
	}
}
