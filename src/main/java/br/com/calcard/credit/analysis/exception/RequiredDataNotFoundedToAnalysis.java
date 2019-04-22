package br.com.calcard.credit.analysis.exception;

public class RequiredDataNotFoundedToAnalysis extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public RequiredDataNotFoundedToAnalysis(String message) {
		super(message);
	}
	
	public RequiredDataNotFoundedToAnalysis(String message, Throwable cause) {
		super(message, cause);
	}

}
