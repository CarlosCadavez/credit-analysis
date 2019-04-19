package br.com.calcard.credit.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.calcard.credit.service.exception.CreditProposeNotFoundedException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(CreditProposeNotFoundedException.class)
	public ResponseEntity<Void> handleCreditProposeNotFoundException(CreditProposeNotFoundedException creditProposeNotFoundException, HttpServletRequest request) {
		return ResponseEntity.notFound().build();
	}
	
	

}
