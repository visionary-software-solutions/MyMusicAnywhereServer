package com.visionarysoftwaresolutions.mymusicanywhere.server;

public class DefaultMyMusicAnywhereServer implements MyMusicAnywhereServer {
	private final MusicLibrary library;
	
	public DefaultMyMusicAnywhereServer(final MusicLibrary library) {
		this.library = library;
	}
	
	public Songs findAllSongsByArtist(Artist toSearch) {
		return library.findAllSongsByArtist(toSearch);
	}

	@Override
	public Songs findAllSongsByName(Name song) {
		return library.findAllSongsByName(song);
	}

	@Override
	public Songs findAllSongsByAlbumName(Name album) {
		return library.findAllSongsByAlbumName(album);
	}

	@Override
	public Albums findAllAlbumsByYear(Year year) {
		return library.findAllAlbumsByYear(year);
	}

}
