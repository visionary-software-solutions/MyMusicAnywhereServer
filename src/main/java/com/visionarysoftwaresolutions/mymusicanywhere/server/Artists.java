package com.visionarysoftwaresolutions.mymusicanywhere.server;

public interface Artists extends Iterable<Artist> {

	boolean contains(Artist artist);
	void addArtist(Artist toAdd);
	boolean isEmpty();

}
