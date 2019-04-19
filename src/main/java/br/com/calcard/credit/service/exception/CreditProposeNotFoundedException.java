package br.com.calcard.credit.service.exception;

public class CreditProposeNotFoundedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CreditProposeNotFoundedException(String message) {
		super(message);
	}
	
	public CreditProposeNotFoundedException(String message, Throwable cause) {
		super(message, cause);
	}

}
