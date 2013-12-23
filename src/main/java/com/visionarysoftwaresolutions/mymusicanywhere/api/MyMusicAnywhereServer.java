package com.visionarysoftwaresolutions.mymusicanywhere.api;

import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.NaturalNumber;
import com.visonarysoftwaresolutions.types.Year;

public interface MyMusicAnywhereServer {

	Songs findAllSongsByArtist(Artist toSearch);

	Songs findAllSongsByName(Name song);

	Songs findAllSongsByAlbumName(Name album);

	Albums findAllAlbumsByYear(Year year);

	Songs findAllSongsByYear(Year year);

	Albums findAllAlbumsByArtist(Artist disturbed);

	Artists findAllArtistsByAlbum(Album album);

	AudioFile getAudioFileForSong(Song createStricken);

	void addAudioForSong(Song song, AudioFile audio);

	NaturalNumber getNumberOfPlaysForSong(Song song);

}
