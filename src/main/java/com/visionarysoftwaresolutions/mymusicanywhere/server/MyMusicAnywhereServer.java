package com.visionarysoftwaresolutions.mymusicanywhere.server;

public interface MyMusicAnywhereServer {

	Songs findAllSongsByArtist(Artist toSearch);

	Songs findAllSongsByName(Name song);

	Songs findAllSongsByAlbumName(Name album);

	Albums findAllAlbumsByYear(Year year);

	Songs findAllSongsByYear(Year year);

	Albums findAllAlbumsByArtist(Artist disturbed);

}
