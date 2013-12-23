package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MyMusicAnywhereServer;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.NaturalNumber;
import com.visonarysoftwaresolutions.types.Year;

public class DefaultMyMusicAnywhereServer implements MyMusicAnywhereServer {
	private final MusicLibrary library;
	private final MusicLibraryAnalyst anal;
	
	public DefaultMyMusicAnywhereServer(final MusicLibrary library,
			final MusicLibraryAnalyst analyzer) {
		this.library = library;
		this.anal = analyzer;
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

	@Override
	public Songs findAllSongsByYear(Year year) {
		return library.findAllSongsByYear(year);
	}

	@Override
	public Albums findAllAlbumsByArtist(Artist disturbed) {
		return library.findAllAlbumsByArtist(disturbed);
	}

	@Override
	public Artists findAllArtistsByAlbum(Album album) {
		return library.findAllArtistsByAlbum(album);
	}

	@Override
	public AudioFile getAudioFileForSong(Song song) {
		anal.incrementNumberOfPlaysForSong(song);
		return library.getAudioFileForSong(song);
	}

	@Override
	public void addAudioForSong(Song song, AudioFile audio) {
		library.addAudioForSong(song, audio);
	}

	@Override
	public NaturalNumber getNumberOfPlaysForSong(Song song) {
		return anal.getNumberOfPlaysForSong(song);
	}
}
