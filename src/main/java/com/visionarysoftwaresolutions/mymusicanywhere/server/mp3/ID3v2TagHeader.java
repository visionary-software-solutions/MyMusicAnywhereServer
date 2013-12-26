package com.visionarysoftwaresolutions.mymusicanywhere.server.mp3;

import java.io.IOException;
import java.io.InputStream;

public class ID3v2TagHeader {
	public  static final int  ID3V2_3_TAG_HEADER_STANDARD_SIZE                 = 10;
	
	private final byte[] header;
	
	public ID3v2TagHeader(InputStream newInputStream) throws TagNotFoundException {
		header = new byte[ID3V2_3_TAG_HEADER_STANDARD_SIZE];
		try {
			newInputStream.read(header);
		} catch (IOException e) {
			throw new TagNotFoundException("Problem reading header", e);  
		}
	}

	public int getTagSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
