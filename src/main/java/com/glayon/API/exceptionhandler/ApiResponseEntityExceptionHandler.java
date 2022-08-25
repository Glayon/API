package com.glayon.API.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ClientApiException.class)
	public ResponseEntity<Object> handlClienteApiException(ClientApiException ex,WebRequest request){
		
		var status = HttpStatus.BAD_REQUEST;
		
		var body = new ErrorApi(status.value(), ex.getMessage());
		
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
	}		
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if (body == null) {
			body = new ErrorApi(status.value(), "Ocorreu um erro inesperadono servidor");
		}
		
		
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	

	
}
