package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Objects;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visonarysoftwaresolutions.types.Name;

public class DefaultSong implements Song {
	private final Name name;
	private final Artist by;

	public DefaultSong(final Name name, final Artist artist) {
		this.name = name;
		by = artist;
	}

	boolean equals(final DefaultSong isEqual) {
		return hashCode() == Objects.hashCode(isEqual);
	}

	@Override
	public boolean equals(final Object toCheck) {
		return (toCheck instanceof DefaultSong)
				&& equals((DefaultSong) toCheck);
	}

	@Override
	public Artist getArtist() {
		return by;
	}

	@Override
	public Name getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, by);
	}
}
