package br.com.calcard.credit.handler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.calcard.credit.domain.ErrorResponse;
import br.com.calcard.credit.service.exception.CreditProposeNotFoundedException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException argumentNotValidException, HttpServletRequest request) {
		String bindErrorResult = getBindResultString(argumentNotValidException.getBindingResult());
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(404);
		errorResponse.setMessage(bindErrorResult);
		errorResponse.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(NOT_FOUND).body(errorResponse);
	}
	
	private String getBindResultString(BindingResult bindingResult) {
		StringBuilder bindError = new StringBuilder();
		
		for (FieldError objectError : bindingResult.getFieldErrors()) {
			bindError.append("The field: ");
			bindError.append(objectError.getField());
			bindError.append(" ");
			bindError.append(objectError.getDefaultMessage());
			bindError.append(" - ");
		}
		
		return bindError.toString();
	}

	@ExceptionHandler(CreditProposeNotFoundedException.class)
	public ResponseEntity<ErrorResponse> handleCreditProposeNotFoundException(CreditProposeNotFoundedException creditProposeNotFoundException, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(404);
		errorResponse.setMessage(creditProposeNotFoundException.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(NOT_FOUND).body(errorResponse);
	}
	

}
