package br.com.calcard.credit.service.exception;

public class ObjectResponseNotFounded extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectResponseNotFounded(String message) {
		super(message);
	}
	
	public ObjectResponseNotFounded(String message, Throwable cause) {
		super(message, cause);
	}

}
