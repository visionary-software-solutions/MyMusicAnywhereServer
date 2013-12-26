package com.visionarysoftwaresolutions.mymusicanywhere.server.mp3;

import java.io.IOException;

public class TagNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -603885813448248912L;

	public TagNotFoundException(String string, IOException e) {
		super(string, e);
	}
}
