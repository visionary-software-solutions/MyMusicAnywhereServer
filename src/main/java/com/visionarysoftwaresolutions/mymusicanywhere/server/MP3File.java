package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class MP3File implements AudioFile {
	private final byte[] data;
	
	public MP3File(final byte[] theData) {
		this.data = theData;
	}
	
	@Override
	public byte[] getBytes() {
		return data;
	}

}
