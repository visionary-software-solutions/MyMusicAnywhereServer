package com.visionarysoftwaresolutions.mymusicanywhere.server;

public interface Songs extends Iterable<Song> {
	boolean contains(Song stricken);

	boolean isEmpty();

	void addSong(Song song);
	void addAll(Songs songs);

}
