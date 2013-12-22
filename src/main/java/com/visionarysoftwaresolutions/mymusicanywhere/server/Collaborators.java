package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collaborators implements Artists {
	private final Collection<Artist> artists = new ArrayList<>();
	
	@Override
	public Iterator<Artist> iterator() {
		return artists.iterator();
	}

	@Override
	public boolean contains(Artist artist) {
		return artists.contains(artist);
	}

	@Override
	public void addArtist(Artist toAdd) {
		if (toAdd != null) {
			artists.add(toAdd);
		}
	}

	@Override
	public boolean isEmpty() {
		return artists.isEmpty();
	}
}
