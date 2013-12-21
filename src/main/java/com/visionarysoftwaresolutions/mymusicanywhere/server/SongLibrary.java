package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SongLibrary implements Songs, Iterable<Song> {
	private final Collection<Song> songs = new ArrayList<>();

	@Override
	public void addSong(final Song song) {
		songs.add(song);
	}

	@Override
	public boolean contains(final Song searchingFor) {
		return songs.contains(searchingFor);
	}

	@Override
	public boolean isEmpty() {
		return songs.isEmpty();
	}

	@Override
	public Iterator<Song> iterator() {
		return songs.iterator();
	}

	@Override
	public void addAll(Songs songs) {
		if (songs!= null) {
			for (Song aSong : songs) {
				addSong(aSong);
			}
		}
	}

	@Override
	public Collection<Artist> getArtists() {
		Collection<Artist> artists = new ArrayList<>();
		for (Song aSong : songs) {
			artists.add(aSong.getArtist());
		}
		return artists;
	}
}
