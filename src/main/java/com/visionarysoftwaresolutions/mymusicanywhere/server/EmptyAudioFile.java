package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;

public class EmptyAudioFile implements AudioFile {

	@Override
	public byte[] getBytes() {
		return new byte[0];
	}

}
