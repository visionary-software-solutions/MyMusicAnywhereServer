package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

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
