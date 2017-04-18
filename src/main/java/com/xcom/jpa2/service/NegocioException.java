package com.xcom.jpa2.service;

public class NegocioException extends Exception {
	
	private static final long serialVersionUID = 1L;

	//Classe para tratar erros //
	
	public NegocioException(String message) {
		
		super(message);
	}

}
