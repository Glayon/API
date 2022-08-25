package com.glayon.API.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

public class ClientApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClientApiException(String mensagem) {
		super(mensagem);
	}
	
}
