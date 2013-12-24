package com.visionarysoftwaresolutions.mymusicanywhere.api;

import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public interface MusicLibrary {

	void addSong(Song toAdd);

	Songs findAllSongsByArtist(Artist toSearch);

	Songs findAllSongsByName(Name song);

	Songs findAllSongsByAlbumName(Name album);

	void addAlbum(Album album);

	Albums findAllAlbumsByYear(Year year);

	Songs findAllSongsByYear(Year year);

	Albums findAllAlbumsByArtist(Artist artist);

	Artists findAllArtistsByAlbum(Album album);

	AudioFile getAudioFileForSong(Song song);

	void addAudioForSong(Song song, AudioFile audio);

	void addTagToSong(Song song, Tag tag);

	Songs getSongsByTagName(Tag sexy);

}
