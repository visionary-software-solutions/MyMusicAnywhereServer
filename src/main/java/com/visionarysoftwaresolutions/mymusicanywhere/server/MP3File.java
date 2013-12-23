package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;

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
