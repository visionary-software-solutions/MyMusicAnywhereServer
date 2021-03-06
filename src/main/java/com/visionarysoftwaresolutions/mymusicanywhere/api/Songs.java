package com.visionarysoftwaresolutions.mymusicanywhere.api;



public interface Songs extends Iterable<Song> {
	boolean contains(Song stricken);

	boolean isEmpty();

	void addSong(Song song);
	void addAll(Songs songs);
	Artists getArtists();

	void addTagToSong(Song song, Tag tag);

	Songs findAllSongsByTag(Tag tag);
}
