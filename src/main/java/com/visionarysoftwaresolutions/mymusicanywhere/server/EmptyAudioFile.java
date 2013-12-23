package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class EmptyAudioFile implements AudioFile {

	@Override
	public byte[] getBytes() {
		return new byte[0];
	}

}
