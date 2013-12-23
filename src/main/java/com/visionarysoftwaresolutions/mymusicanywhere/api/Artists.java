package com.visionarysoftwaresolutions.mymusicanywhere.api;


public interface Artists extends Iterable<Artist> {

	boolean contains(Artist artist);
	void addArtist(Artist toAdd);
	boolean isEmpty();

}
