package com.visionarysoftwaresolutions.mymusicanywhere.server.mp3;

import java.io.InputStream;


public class ID3TagFactory {

	public static ID3Tag createTag(final InputStream newInputStream) {
		ID3Tag result;
		try {
			result = createID3v2Tag(newInputStream);
		} catch (final TagNotFoundException e) {
			System.err.println("Was not ID3v2 Tag. Try ID3v1"
					+ e.getLocalizedMessage());
			try {
				result = createID3v1Tag(newInputStream);
			} catch (final TagNotFoundException ex) {
				System.err.println("Was not ID3v1 Tag..."
						+ e.getLocalizedMessage());
				result = new EmptyID3Tag();
			}
		}
		return result;
	}
	
	private static ID3Tag createID3v2Tag(final InputStream newInputStream)
			throws TagNotFoundException {
		return new ID3v2Tag(newInputStream);
	}
	
	private static ID3Tag createID3v1Tag(final InputStream newInputStream)
			throws TagNotFoundException {
		return new ID3v1Tag(newInputStream);
	}
}
