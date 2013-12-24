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
		return anal.findAllAlbumsByArtist(library, disturbed);
	}

	@Override
	public Albums findAllAlbumsByYear(final Year year) {
		return anal.findAllAlbumsByYear(library, year);
	}

	@Override
	public Artists findAllArtistsByAlbum(final Album album) {
		return anal.findAllArtistsByAlbum(library, album);
	}

	@Override
	public Songs findAllSongsByAlbumName(final Name album) {
		return anal.findAllSongsByAlbumName(library, album);
	}

	@Override
	public Songs findAllSongsByArtist(final Artist toSearch) {
		return anal.findAllSongsByArtist(library, toSearch);
	}

	@Override
	public Songs findAllSongsByName(final Name song) {
		return anal.findAllSongsByName(library, song);
	}

	@Override
	public Songs findAllSongsByYear(final Year year) {
		return anal.findAllSongsByYear(library, year);
	}

	@Override
	public AudioFile getAudioFileForSong(final Song song) {
		return library.getAudioFileForSong(song);
	}

	@Override
	public Plays getPlaysForSong(final Song song) {
		return anal.getPlaysForSong(library, song);
	}

	@Override
	public Songs findAllSongsByTag(final Tag sexy) {
		return anal.findAllSongsByTag(library, sexy);
	}
}
