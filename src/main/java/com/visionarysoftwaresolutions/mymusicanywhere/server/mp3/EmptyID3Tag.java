package com.visionarysoftwaresolutions.mymusicanywhere.server.mp3;

public class EmptyID3Tag implements ID3Tag {

	@Override
	public String getTitle() {
		return "";
	}

	@Override
	public String getArtist() {
		return "";
	}

	@Override
	public String getAlbum() {
		return "";
	}

	@Override
	public String getYear() {
		return "";
	}

}
