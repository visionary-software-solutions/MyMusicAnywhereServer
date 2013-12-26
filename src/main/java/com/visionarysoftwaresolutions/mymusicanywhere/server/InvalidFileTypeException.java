package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class InvalidFileTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6572478573092539468L;
	
	private final String fileName;
	
	public InvalidFileTypeException(String message, String fileName) {
		super(message);
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
}
