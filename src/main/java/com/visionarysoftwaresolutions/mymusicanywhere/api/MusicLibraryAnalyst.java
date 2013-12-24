package com.visionarysoftwaresolutions.mymusicanywhere.api;

import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;


public interface MusicLibraryAnalyst {

	void incrementNumberOfPlaysForSong(Song song);

	Plays getPlaysForSong(Song song);
	
	Songs findAllSongsByArtist(MusicLibrary library, Artist toSearch);

	Songs findAllSongsByName(MusicLibrary library, Name song);

	Songs findAllSongsByAlbumName(MusicLibrary library, Name album);
	
	Albums findAllAlbumsByYear(MusicLibrary library, Year year);

	Songs findAllSongsByYear(MusicLibrary library, Year year);

	Albums findAllAlbumsByArtist(MusicLibrary library, Artist artist);

	Artists findAllArtistsByAlbum(MusicLibrary library, Album album);
	
	Songs findAllSongsByTag(MusicLibrary library, Tag sexy);

}
