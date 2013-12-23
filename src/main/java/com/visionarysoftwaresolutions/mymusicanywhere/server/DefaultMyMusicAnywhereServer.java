package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

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
		return library.getAudioFileForSong(song);
	}

	@Override
	public void addAudioForSong(Song song, AudioFile audio) {
		library.addAudioForSong(song, audio);
	}
}
