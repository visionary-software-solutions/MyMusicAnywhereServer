package com.visionarysoftwaresolutions.mymusicanywhere.server.mp3;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ID3v2Tag implements ID3Tag {
	public static int DEFAULT_PADDING_SIZE = 2048;
	
	private final ID3v2TagHeader header;
	private final List<ID3v2Frame> frames;
	private final byte[] padding;
	private final int size;
	
	public ID3v2Tag(InputStream newInputStream) throws TagNotFoundException {
		header = new ID3v2TagHeader(newInputStream);
		//TODO: figure out how to parse the header using BeagleBuddy as a guide.
		size = header.getTagSize();
		frames = new ArrayList<>();
		padding = new byte[DEFAULT_PADDING_SIZE]; 
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getArtist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlbum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getYear() {
		// TODO Auto-generated method stub
		return null;
	}

}
