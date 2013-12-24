package com.visionarysoftwaresolutions.mymusicanywhere.server;

import com.visionarysoftwaresolutions.mymusicanywhere.api.Album;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Albums;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artist;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Artists;
import com.visionarysoftwaresolutions.mymusicanywhere.api.AudioFile;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibrary;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MusicLibraryAnalyst;
import com.visionarysoftwaresolutions.mymusicanywhere.api.MyMusicAnywhereServer;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Plays;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Song;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Songs;
import com.visionarysoftwaresolutions.mymusicanywhere.api.Tag;
import com.visonarysoftwaresolutions.types.Name;
import com.visonarysoftwaresolutions.types.Year;

public class DefaultMyMusicAnywhereServer implements MyMusicAnywhereServer {
	private final MusicLibrary library;
	private final MusicLibraryAnalyst anal;

	public DefaultMyMusicAnywhereServer(final MusicLibrary library,
			final MusicLibraryAnalyst analyzer) {
		this.library = library;
		anal = analyzer;
	}

	@Override
	public void addAudioForSong(final Song song, final AudioFile audio) {
		library.addAudioForSong(song, audio);
	}

	@Override
	public Albums findAllAlbumsByArtist(final Artist disturbed) {
		return library.findAllAlbumsByArtist(disturbed);
	}

	@Override
	public Albums findAllAlbumsByYear(final Year year) {
		return library.findAllAlbumsByYear(year);
	}

	@Override
	public Artists findAllArtistsByAlbum(final Album album) {
		return library.findAllArtistsByAlbum(album);
	}

	@Override
	public Songs findAllSongsByAlbumName(final Name album) {
		return library.findAllSongsByAlbumName(album);
	}

	@Override
	public Songs findAllSongsByArtist(final Artist toSearch) {
		return library.findAllSongsByArtist(toSearch);
	}

	@Override
	public Songs findAllSongsByName(final Name song) {
		return library.findAllSongsByName(song);
	}

	@Override
	public Songs findAllSongsByYear(final Year year) {
		return library.findAllSongsByYear(year);
	}

	@Override
	public AudioFile getAudioFileForSong(final Song song) {
		anal.incrementNumberOfPlaysForSong(song);
		return library.getAudioFileForSong(song);
	}

	@Override
	public Plays getPlaysForSong(final Song song) {
		return anal.getPlaysForSong(song);
	}

	@Override
	public Songs findAllSongsByTag(final Tag sexy) {
		return library.getSongsByTagName(sexy);
	}
}
