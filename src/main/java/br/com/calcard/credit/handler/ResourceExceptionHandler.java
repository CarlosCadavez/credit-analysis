package br.com.calcard.credit.handler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.calcard.credit.domain.ErrorResponse;
import br.com.calcard.credit.service.exception.CreditProposeNotFoundedException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(CreditProposeNotFoundedException.class)
	public ResponseEntity<ErrorResponse> handleCreditProposeNotFoundException(CreditProposeNotFoundedException creditProposeNotFoundException, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(404);
		errorResponse.setMessage(creditProposeNotFoundException.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(NOT_FOUND).body(errorResponse);
	}
	

}
