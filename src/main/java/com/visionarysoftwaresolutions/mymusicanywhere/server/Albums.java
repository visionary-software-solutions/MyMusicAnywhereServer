package com.visionarysoftwaresolutions.mymusicanywhere.server;


public interface Albums extends Iterable<Album> {

	boolean contains(Album album);

	void addAlbum(Album album);

}
