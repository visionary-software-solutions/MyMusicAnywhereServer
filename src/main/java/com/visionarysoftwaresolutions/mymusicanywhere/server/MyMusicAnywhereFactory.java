package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class MyMusicAnywhereFactory {
	static Name createName(String name) {
		return new Name(name);
	}
	
	static Year createYear(final int year) {
		return new Year(new NaturalNumber(year));
	}
	
	static MusicLibrary createLibrary() {
		return new DefaultMusicLibrary();
	}
	
	static Song createSong(Name name, Artist artist) {
		return new DefaultSong(name, artist);
	}

	static Artist createArtist(String string) {
		return new DefaultArtist(string);
	}

	static Album createAlbum(Name name, Year year, Songs songs) {
		return new DefaultAlbum(name, year, songs);
	}
}
