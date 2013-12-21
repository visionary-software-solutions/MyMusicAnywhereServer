package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class DefaultAlbum implements Album {
	private final Name name;
	private final Year year;
	private final Songs trax;

	public DefaultAlbum(final Name name, 
			final Year year,
			final Songs tracks) {
		this.name = name;
		this.year = year;
		trax = tracks;
	}

	@Override
	public Name getName() {
		return name;
	}

	@Override
	public Songs getSongs() {
		return trax;
	}

	@Override
	public Year getYear() {
		return year;
	}

	@Override
	public Artists getArtists() {
		return trax.getArtists();
	}
}
