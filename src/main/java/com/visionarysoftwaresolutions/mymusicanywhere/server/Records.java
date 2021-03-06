package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visonarysoftwaresolutions.types.Year;

public class Records implements Albums {
	Collection<Album> albums = new ArrayList<>();
	
	@Override
	public void addAlbum(final Album album) {
		albums.add(album);
	}
	
	@Override
	public boolean contains(Album album) {
		return albums.contains(album);
	}

	@Override
	public Iterator<Album> iterator() {
		return albums.iterator();
	}

	@Override
	public Collection<Year> getYears() {
		Collection<Year> years = new ArrayList<>();
		for (Album anAlbum : albums) {
			years.add(anAlbum.getYear());
		}
		return years;
	}

	@Override
	public boolean isEmpty() {
		return albums.isEmpty();
	}

}
