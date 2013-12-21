package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Collection;

public interface Songs extends Iterable<Song> {
	boolean contains(Song stricken);

	boolean isEmpty();

	void addSong(Song song);
	void addAll(Songs songs);
	Collection<Artist> getArtists();
}
