package com.visionarysoftwaresolutions.mymusicanywhere.server;

public interface MusicLibrary {

	void addSong(Song toAdd);

	Songs findAllSongsByArtist(Artist toSearch);

	Songs findAllSongsByName(Name song);

	Songs findAllSongsByAlbumName(Name album);

	void addAlbum(Album album);

	Albums findAllAlbumsByYear(Year year);

	Songs findAllSongsByYear(Year year);

	Albums findAllAlbumsByArtist(Artist artist);

}
