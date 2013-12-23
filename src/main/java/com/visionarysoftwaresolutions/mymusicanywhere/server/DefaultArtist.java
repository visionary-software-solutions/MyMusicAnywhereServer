package com.visionarysoftwaresolutions.mymusicanywhere.server;

import java.util.Objects;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;

public class DefaultArtist implements Artist {
	private final String name;
	
	public DefaultArtist(final String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	@Override
	public boolean equals(final Object toCheck) {
		return toCheck instanceof DefaultArtist && equals((DefaultArtist) toCheck); 
	}
	
	boolean equals(final DefaultArtist isEqual) {
		return hashCode() == Objects.hashCode(isEqual);
	}
	
}
