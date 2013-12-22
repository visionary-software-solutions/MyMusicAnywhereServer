package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Collection;


public interface Albums extends Iterable<Album> {

	boolean contains(Album album);

	void addAlbum(Album album);
	
	Collection<Year> getYears();

	boolean isEmpty();

}
